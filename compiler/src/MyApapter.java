import com.sun.jdi.Value;
import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.*;

public class MyApapter extends DepthFirstAdapter
{
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

    MyApapter() {
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

            System.out.println(node.getExpression().getClass().getName());
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
        if(node.getIdentifier() != null)
        {
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

    // TODO Remove this
    @Override
    public void outAOpenExpression(AOpenExpression node) {
        PExpression e1 = node.getE1();
        PExpression e2 = node.getE2();
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            PValue p1 = v1.getValue();
            if (p1 instanceof ANoneValue){
                ANoneValue noneValue = (ANoneValue) p1;
                int line = noneValue.getNone().getLine();
                int pos = noneValue.getNone().getPos();
                System.err.printf("[%d , %d]Open expression can't have none values%n", line, pos);
            }
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            PValue p1 = v1.getValue();
            if (p1 instanceof ANoneValue){
                ANoneValue noneValue = (ANoneValue) p1;
                int line = noneValue.getNone().getLine();
                int pos = noneValue.getNone().getPos();
                System.err.printf("[%d , %d]Open expression can't have none values%n", line, pos);
            }
        }
    }

    public static void showError(int line , int col , String message){
        System.out.printf("[%d,%d] %s" , line , col , message);
    }

    @Override
    public void outAArithmeticExpression(AArithmeticExpression node) {
        PExpression left =  node.getE1();
        PExpression right = node.getE2();
        int line = getBinopLine(node.getBinop());
        int pos = getBinopCol(node.getBinop());
        if (left instanceof AOpenExpression | right instanceof AOpenExpression){
            showError(line , pos , "An arithmetic expression cannot have open operands" );
        }
        if (left instanceof ATypeExpression | right instanceof ATypeExpression){
            showError(line , pos , "An arithmetic expression cannot have type operands" );
        }
        if (expressionIsNone(left) || expressionIsNone(right)){
            showError(line , pos, "An arithmetic expression cannot have None value operands");
        }
    }
    public static boolean expressionIsNone(PExpression e){
        if (e instanceof AValueExpression){
            AValueExpression v = (AValueExpression) e;
            return v.getValue() instanceof ANoneValue;
        }
        return false;
    }
    // TODO Easier way to do this ??
    public static int getBinopLine(PBinop op){
        if (op instanceof AMinusBinop){
            return ((AMinusBinop) op).getMinus().getLine();
        }
        if (op instanceof APlusBinop){
            return ((APlusBinop) op).getPlus().getLine();
        }
        if (op instanceof ADivBinop){
            return ((ADivBinop) op).getDiv().getLine();
        }
        if (op instanceof AMultBinop){
            return ((AMultBinop) op).getMult().getLine();
        }
        if (op instanceof AModuloBinop){
            return ((AModuloBinop) op).getMode().getLine();
        }
        if (op instanceof APowBinop){
            return ((APowBinop) op).getDmult().getLine();
        }
        return -1;
    }
    public static int getBinopCol(PBinop op){
        if (op instanceof AMinusBinop){
            return ((AMinusBinop) op).getMinus().getPos();
        }
        if (op instanceof APlusBinop){
            return ((APlusBinop) op).getPlus().getPos();
        }
        if (op instanceof ADivBinop){
            return ((ADivBinop) op).getDiv().getPos();
        }
        if (op instanceof AMultBinop){
            return ((AMultBinop) op).getMult().getPos();
        }
        if (op instanceof AModuloBinop){
            return ((AModuloBinop) op).getMode().getPos();
        }
        if (op instanceof APowBinop){
            return ((APowBinop) op).getDmult().getPos();
        }
        return -1;
    }

    class Variable {
        String name;
        String type;
        Variable(String name, String type){
            this.name=name;
            this.type=type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Variable variable = (Variable) o;
            return Objects.equals(name, variable.name) &&
                    Objects.equals(type, variable.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, type);
        }
    }
    class Function{
        String name;
        int line;
        int column;

        // the sum of defined or non defined variables
        // it depends on the type of function:
        // function definition->sum of non defined,
        // function call->sum of given arguments
        int sum;
        // available only for function definition
        // total function's arguments
        int total;

        public Function(String name, int line, int column, int sum, int total) {
            this.name = name;
            this.line = line;
            this.column = column;
            this.sum = sum;
            this.total = total;
        }

        public Function(String name, int line, int column, int sum) {
            this.name = name;
            this.line = line;
            this.column = column;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Function function = (Function) o;
            return line == function.line &&
                    column == function.column &&
                    sum == function.sum &&
                    Objects.equals(name, function.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, line, column, sum);
        }
    }
}