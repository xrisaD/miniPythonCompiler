import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.*;

/**
 * Adapter class responsible for performing type checks
 */
public class TypeChecker extends DepthFirstAdapter
{
    SymbolTable symbolTable;
    HashMap<String,Variable> variables;
    boolean hasError = false;

    // Indicates if the adapter is inside a function definition
    boolean inAFunction = false;


    public TypeChecker(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        variables = new HashMap<>();
        Hashtable<String, ArrayList<FunctionDefinition>> fdefs = symbolTable.getFunctionDefinitions();

        // Because when fdefs are created the symbol table is not ready we need to translate them now
        for (String k : fdefs.keySet()) {
            for (FunctionDefinition fd : fdefs.get(k)) {

                if(fd.retType.equals("to_be_decided")) {
                    fd.retDef = symbolTable.getDefinitionForCall(
                            symbolTable.getFuncCallObject((AFunctionCall) fd.retFuncCall)
                    );
                }
            }
        }

        // Algorithm pls...
        // If the function has a arithm expression return type, ret type is number
        // If the function has func call ret statement  -> ret type is to be defined
        for (String k : fdefs.keySet()){
            for (FunctionDefinition fd : fdefs.get(k)) {
                FunctionDefinition initial = fd;
                FunctionDefinition current = fd;

                HashSet<FunctionDefinition> visited = new HashSet<>();
                visited.add(current);

                boolean found = false;
                while (current.retType.equals("to_be_decided")) {
                    // get functiondefinition of the returned function
                    // TODO get function def
                    FunctionDefinition returnfdef = current.getReturnDef();
                    // If there is a cycle in the call graph, we can't infer the type so we set as unknown
                    if (visited.contains(returnfdef)) {
                        // set the final ret type
                        initial.retType = "unknown";
                        found = true;
                        break;
                    }
                    visited.add(returnfdef);

                    // Advance to next function
                    current = returnfdef;

                }
                if (!found) {
                    initial.retType = current.retType;

                }
            }
        }

    }

    @Override
    public void inAFunction(AFunction node) {
        super.inAFunction(node);
        inAFunction = true;
    }

    @Override
    public void outAFunction(AFunction node) {
        super.inAFunction(node);
        inAFunction = false;
    }

    @Override
    public void inAFunctionCall(AFunctionCall node) {
        String func_name = node.getIdentifier().getText();
        LinkedList args = node.getExpression();
        Object[] argsArray = args.toArray();
        FunctionDefinition def =  symbolTable.getDefinitionForCall(symbolTable.getFuncCallObject(node));
        ArrayList<String> expectedTypes = def.getExpectedTypes();
        FunctionCall funcCallObject = symbolTable.getFuncCallObject(node);
        // Expected types is larger than args because it coantains types for default arguments as well
        for (int i = 0 ; i < argsArray.length ; i++){
            PExpression expr = (PExpression) argsArray[i];
            String type = getExpressionType(expr);
            if (!type.equals(expectedTypes.get(i)) && !expectedTypes.get(i).equals("any")){
                showError(funcCallObject.line, funcCallObject.column, "Unexpected type " + type + " as " +
                        "function argument");
                System.out.println("Expected types " + expectedTypes);
                System.out.println("Current type " + type);
            }
        }
    }
    // TODO get expected types of function return values (if they have) what do we do when they do not return anything though


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
        else if(node.getExpression() instanceof AArithmeticExpression|
                node.getExpression() instanceof AMinExpression|
                node.getExpression() instanceof AMaxExpression){
            variables.put(vname,new Variable(vname,"number"));
        }
        else if(node.getExpression() instanceof AOpenExpression){
            variables.put(vname,new Variable(vname,"open"));
        }
        else if(node.getExpression() instanceof ATypeExpression){
            variables.put(vname,new Variable(vname,"type"));
        }
        // Now this is a big fucking problem
        else if(node.getExpression() instanceof ASubscriptionExpression){
            variables.put(vname,new Variable(vname,"unknown"));
        }
        // another problem , we need to refactor this to a general method of finding types of expression
        else if(node.getExpression() instanceof AParExpression){
            variables.put(vname,new Variable(vname,"unknown"));
        }
        else{
            //number
            variables.put(vname,new Variable(vname,"unknown"));
        }
    }

    // TODO we need to know if this is an arithmetic expression inside of a function ( we dont know the arguments types)
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

        // All further checks can't be procesed if we are inside a function definition (we don't know arguments types)
        if (inAFunction){
            return;
        }
        // TODO if return type of function is not a number show error
        // if left is function call expression and ret type is not number show error
        if (left instanceof AFuncCallExpression){
            AFuncCallExpression functionCall= ((AFuncCallExpression) left);
            FunctionCall call = symbolTable.getFuncCallObject(functionCall);
            FunctionDefinition fdef = symbolTable.getDefinitionForCall(call);
            System.out.println("Return type of fnc 1 " + fdef.retType );
             if (!(fdef.retType.equals("number") || fdef.retType.equals("unknown"))){
                 showError(line , pos, "Invalid type for arithmetic expression");
             }
        }
        // if right is function call expression and ret type is not number show error
        if (right instanceof AFuncCallExpression){
            AFuncCallExpression functionCall= ((AFuncCallExpression) right);
            FunctionCall call = symbolTable.getFuncCallObject(functionCall);
            FunctionDefinition fdef = symbolTable.getDefinitionForCall(call);
            System.out.println("Return type of fnc 2 " + fdef.retType );
            if (!(fdef.retType.equals("number") || fdef.retType.equals("unknown")) ){
                showError(line , pos, "Invalid type for arithmetic expression");
            }
        }
        // Todo check identifiers type ..
        if (right instanceof AIdentifierExpression){
            String name = ((AIdentifierExpression) right).getIdentifier().getText();
            Variable x = variables.get(name);
            System.out.println("Left variable name " + name);
            if (!(x.type.equals("number") || x.type.equals("unknown"))){
                showError(line , pos, "Invalid type for arithmetic expression");
            }
            System.out.println("Left variable type " + x.type);
        }
        if (left instanceof AIdentifierExpression){
            String name = ((AIdentifierExpression) left).getIdentifier().getText();
            Variable x = variables.get(name);
            System.out.println("Right variable name " + name);
            if (!(x.type.equals("number") || x.type.equals("unknown"))){
                showError(line , pos, "Invalid type for arithmetic expression");
            }
            System.out.println("Right variable type " + x.type);
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

    public String getExpressionType(PExpression e){
        if (e instanceof AArithmeticExpression
                | e instanceof AMinExpression
                | e instanceof AMaxExpression){
            return "number";
        }
        if (e instanceof AIdentifierExpression){
            String vname = ((AIdentifierExpression) e).getIdentifier().getText();
            return symbolTable.getVariable(vname).type;
        }
        if (e instanceof AValueExpression){
            AValueExpression aValueExpression = (AValueExpression) e;
            if (aValueExpression.getValue() instanceof ANumberValue) {
                return "number";
            }
        }
        if (e instanceof AParExpression){
            return getExpressionType(((AParExpression) e).getExpression());
        }
        return "not_number";
    }

    public void showError(int line , int col , String message){
        System.out.printf("[%d,%d] %s%n" , line , col , message);
        hasError = true;
    }

}