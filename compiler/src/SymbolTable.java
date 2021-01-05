import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class SymbolTable extends DepthFirstAdapter {

    // variables: defined variables
    // fcall: called functions
    // fdef: defined functions
    private Hashtable<String, Variable> variables;
    private Hashtable<String, ArrayList<Function>> fcall;
    private Hashtable<String, ArrayList<Function>> fdef;


    // TODO Notes: move symbol table as another class , i think it must perform checks 1 , 2 , 3  , 7( and 5?)
    // TODO Notes : create type checker that checks 4 , 6
    // TODO Notes : check unseen identifier on type expr

    // TODO : How to check types
    // TODO : Open types , typetypes
    // For every arithmetic expression check  that both e1 and e2 are numbers
    // Need to get e1's type and e2's type
    // three cases for e1 : 1) function call , method , ar.expr , identifier , open , type , String , None
    // if its 1 , get fcalls return type
    // if its 2 get methods return type
    // if its id get identifiers type
    // if its String tpye is tring
    // if None type is nonetype

    // Identifiers type : inferred from assignment of expression ( back to square 1)
    // Fcalls / method type : if there is no return statement then NoneType
    //                        if there is return expr , then return expr type

    // Problems

    // Function that returns a input var : Same type as the input variable .. Need to know variables output

    // Series of functions whose calls create a circle : Every functions return type depends on its own return type...
    // Some functions may never return and create an infinite loop

    SymbolTable() {
        this.variables = new Hashtable<String, Variable>();
        this.fcall = new Hashtable<String, ArrayList<Function>>();
        this.fdef = new Hashtable<String, ArrayList<Function>>();
    }

    @Override
    public void inAAssignStatement(AAssignStatement node) {
        String vname = node.getIdentifier().getText();

        if(node.getExpression() instanceof AValueExpression){
            PValue value = ((AValueExpression) node.getExpression()).getValue();
            if(value instanceof ANoneValue){
                // none
                variables.put(vname,new Variable(vname,"none"));
            }
            else if(value instanceof ANumberValue){
                //number
                variables.put(vname,new Variable(vname,"number"));
            }
            else if(value instanceof AStringValue){
                //string
                variables.put(vname,new Variable(vname,"string"));
            }
        }
        else if(node.getExpression() instanceof AListDefExpression){
            variables.put(vname,new Variable(vname,"list"));
        }
        else if(node.getExpression() instanceof AIdentifierExpression){
            variables.put(vname,new Variable(vname,"identifier"));
        }
        else if(node.getExpression() instanceof AFuncCallExpression){
            variables.put(vname,new Variable(vname,"function call"));
        }
        else{
            //number
            variables.put(vname,new Variable(vname,"number"));
            variables.put(vname,new Variable(vname,"expression"));
        }
    }


    // called when a variable is used
    @Override
    public void inAIdentifierExpression(AIdentifierExpression node) {
        String vname = node.getIdentifier().getText();
        int line = node.getIdentifier().getLine();
        int pos = node.getIdentifier().getPos();

        if(variables.get(vname)==null){
            System.out.println("You are trying to access undefined variable "+vname+" ["+line+","+pos+"]");
        }
    }


    @Override
    public void inAIdentifierValue(AIdentifierValue node) {
        String vname = node.getIdentifier().getText();
        variables.put(vname,new Variable(vname,""));
    }

    public void caseAFunction(AFunction node) {
        inAFunction(node);
        if(node.getIdentifier() != null) {
            node.getIdentifier().apply(this);
        }
        {
            int sumNonDef = 0;
            Object temp[] = node.getIdentifierValue().toArray();
            for(int i = 0; i < temp.length; i++) {
                ((PIdentifierValue) temp[i]).apply(this);
                if(((AIdentifierValue) temp[i]).getValue()==null){
                    sumNonDef+=1;
                }
            }

            String fname = node.getIdentifier().getText();
            int line = node.getIdentifier().getLine();
            int pos = node.getIdentifier().getPos();

            if(fdef.get(fname)==null){
                Function newFunDef = new Function(fname, line, pos, sumNonDef, temp.length);
                fdef.put(fname, new ArrayList<Function>());
                fdef.get(fname).add(newFunDef);

            }else{
                ArrayList<Function> functions = fdef.get(fname);
                for (Function f:functions){
                    if(f.sum==sumNonDef){
                        System.out.println("Redefinition of "+fname+" with "+sumNonDef+" arguments");
                    }
                }

                Function newFunDef = new Function(fname, line, pos, sumNonDef, temp.length);
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
                Function newFunCall = new Function(fname, line, pos, temp.length);
                fcall.put(fname, new ArrayList<Function>());
                fcall.get(fname).add(newFunCall);
            }
        }
        outAFunctionCall(node);
    }

    @Override
    public void outStart(Start node) {
        for (String k: fcall.keySet()) {
            ArrayList<Function> funcCalls = fcall.get(k);
            if(fdef.get(k)==null){
                System.out.println("Undefined function in line "+funcCalls.get(0).line);
            }
            else{
                ArrayList<Function> allDefinitions = fdef.get(k);
                for(Function funcCall:funcCalls){
                    int sumGivenArgs = funcCall.sum;

                    boolean isOk = false;
                    for(Function fd:allDefinitions){
                        int sumNonDefArgs = fd.sum;
                        int sumTotalArgs = fd.total;

                        if(sumNonDefArgs<=sumGivenArgs && sumGivenArgs<=sumTotalArgs){
                            isOk = true;
                        }
                    }
                    if(!isOk) {
                        System.out.println("Wrong number of parameters given at function "+k);
                    }
                }
            }
        }
    }
}
