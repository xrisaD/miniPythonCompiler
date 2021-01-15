import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.*;

/**
 * Adapter class responsible for performing type checks
 */
public class TypeChecker extends DepthFirstAdapter
{
    SymbolTable symbolTable;
    boolean hasError = false;
    public TypeChecker(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
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
            }
        }
    }
    // TODO get expected types of function return values (if they have) what do we do when they do not return anything though

    public void showError(int line , int col , String message){
        System.out.printf("[%d,%d] %s%n" , line , col , message);
        hasError = true;
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
        // TODO if return type of function is not a number show error
        // if left is function call expression and ret type is not number show error
        if (left instanceof AFuncCallExpression){
            AFuncCallExpression functionCall= ((AFuncCallExpression) left);
            FunctionCall call = symbolTable.getFuncCallObject(functionCall);
            FunctionDefinition fdef = symbolTable.getDefinitionForCall(call);
             if (!fdef.retType.equals("number")){
                 showError(line , pos, "Invalid type for arithmetic expression");
             }
        }
        // if right is function call expression and ret type is not number show error
        if (right instanceof AFuncCallExpression){
            AFuncCallExpression functionCall= ((AFuncCallExpression) right);
            FunctionCall call = symbolTable.getFuncCallObject(functionCall);
            FunctionDefinition fdef = symbolTable.getDefinitionForCall(call);
            if (!fdef.retType.equals("number")){
                showError(line , pos, "Invalid type for arithmetic expression");
            }
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
        return "not_number";
    }

}