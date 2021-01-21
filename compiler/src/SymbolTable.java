import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class SymbolTable extends DepthFirstAdapter {

    // variables: defined variables
    // fcall: called functions
    // fdef: defined functions
    private Hashtable<String, Variable> variables;
    private Hashtable<String, ArrayList<FunctionCall>> fcall;
    private Hashtable<String, ArrayList<FunctionDefinition>> fdef;

    boolean isReady = false;
    boolean hasError = false;

    SymbolTable() {
        this.variables = new Hashtable<String, Variable>();
        this.fcall = new Hashtable<String, ArrayList<FunctionCall>>();
        this.fdef = new Hashtable<String, ArrayList<FunctionDefinition>>();
    }
    @Override
    public void inAAssignStatement(AAssignStatement node) {
        String vname = node.getIdentifier().getText();

        // WE don't need to keep track of the type
        variables.put(vname, new Variable(vname, ""));

    }


    // called when a variable is used
    @Override
    public void inAIdentifierExpression(AIdentifierExpression node) {
        String vname = node.getIdentifier().getText();
        int line = node.getIdentifier().getLine();
        int pos = node.getIdentifier().getPos();

        if(variables.get(vname)==null){
            showError(line, pos, "undefined variable "+vname);
        }
    }

    // This is useful because we assume that a function argument can be referened inside and outside the function
    @Override
    public void inAIdentifierValue(AIdentifierValue node) {
        String vname = node.getIdentifier().getText();
        variables.put(vname,new Variable(vname,"argument"));
    }

    public void caseAFunction(AFunction node) {
        inAFunction(node);
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            int sumNonDef = 0;
            Object temp[] = node.getIdentifierValue().toArray();
            ArrayList<AIdentifierValue> idValuesList = new ArrayList<>();
            ArrayList<String> varNames = new ArrayList<>();
            PStatement statement =  node.getStatement();
            for(int i = 0; i < temp.length; i++) {
                idValuesList.add((AIdentifierValue) temp[i]);
                ((PIdentifierValue) temp[i]).apply(this);
                if(((AIdentifierValue) temp[i]).getValue()==null){
                    sumNonDef+=1;
                }
                varNames.add(((AIdentifierValue) temp[i]).getIdentifier().getText());
            }

            String fname = node.getIdentifier().getText();
            int line = node.getIdentifier().getLine();
            int pos = node.getIdentifier().getPos();

            FunctionDefinition newFunDef = new FunctionDefinition(fname, line, pos, sumNonDef, temp.length);
            // Finding expected argument types
            TypeFinder mtf =  new TypeFinder(varNames);
            System.out.println("Applygin tpy finder for func " + fname);
            node.getStatement().apply(mtf);
            ArrayList<String> expectedTypes =  mtf.getExpectedTypes();
            newFunDef.setExpectedTypes(expectedTypes);
            System.out.println("Expected types " + expectedTypes);

            newFunDef.setIdentifierValues(idValuesList);
            newFunDef.setStatement(statement);


            if(fdef.get(fname)==null){
                fdef.put(fname, new ArrayList<FunctionDefinition>());
                fdef.get(fname).add(newFunDef);

            }
            else{
                ArrayList<FunctionDefinition> functions = fdef.get(fname);
                for (FunctionDefinition f:functions){
                    if(newFunDef.redefines(f)){
                        showError(newFunDef.line, newFunDef.col,"Redefinition of "+fname+" with "+sumNonDef+" arguments");
                    }
                }
                fdef.get(fname).add(newFunDef);
            }
        }
        if(node.getStatement() != null) {
            node.getStatement().apply(this);
        }
        outAFunction(node);
    }
    public void caseAFunctionCall(AFunctionCall node) {
        inAFunctionCall(node);
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            Object temp[] = node.getExpression().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PExpression) temp[i]).apply(this);
            }
            String fname = node.getIdentifier().getText();
            int line = node.getIdentifier().getLine();
            int pos = node.getIdentifier().getPos();

            if(fcall.get(fname)==null){
                FunctionCall newFunCall = new FunctionCall(fname, line, pos, temp.length);
                fcall.put(fname, new ArrayList<FunctionCall>());
                fcall.get(fname).add(newFunCall);
            }
        }
        outAFunctionCall(node);
    }

    @Override
    public void outStart(Start node) {
        for (String k: fcall.keySet()) {
            ArrayList<FunctionCall> funcCalls = fcall.get(k);
            if(fdef.get(k)==null){
                showError(funcCalls.get(0).line,funcCalls.get(0).column,"Undefined function");
            }
            else{
                ArrayList<FunctionDefinition> allDefinitions = fdef.get(k);
                for(FunctionCall funcCall:funcCalls){
                    boolean isOk = false;
                    for(FunctionDefinition fd:allDefinitions){
                        if(fd.matches(funcCall)){
                            isOk = true;
                        }
                    }
                    if(!isOk) {
                        showError(funcCall.line, funcCall.column, "Wrong number of parameters given at function "+k);

                    }
                }
            }
        }
        isReady = true;
    }

    public FunctionCall getFuncCallObject(AFuncCallExpression expr){
        AFunctionCall func = (AFunctionCall) expr.getFunctionCall();
        return getFuncCallObject(func);
    }
    public FunctionCall getFuncCallObject(AFunctionCall call){
        Object temp[] = call.getExpression().toArray();
        String fname = call.getIdentifier().getText();
        int line = call.getIdentifier().getLine();
        int pos = call.getIdentifier().getPos();

        return new FunctionCall(fname, line, pos, temp.length);
    }
    public FunctionDefinition getDefinitionForCall(FunctionCall call){
        for (FunctionDefinition fd : fdef.get(call.name)){
            if (fd.matches(call)){
                return fd;
            }
        }
        return null;
    }
    public Variable getVariable(String s){
        return variables.get(s);
    }
    public Hashtable<String, ArrayList<FunctionDefinition>>  getFunctionDefinitions(){
        return fdef;
    }

    public void showError(int line , int col , String message){
        System.out.printf("[%d,%d] %s%n" , line , col , message);
        hasError = true;
    }
}
