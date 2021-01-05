import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.*;

/**
 * Adapter class responsible for performing type checks
 */
public class MyApapter extends DepthFirstAdapter
{
    SymbolTable s;
    public MyApapter(SymbolTable s) {
        this.s = s;
    }

    @Override
    public void inAFunctionCall(AFunctionCall node) {
        String func_name = node.getIdentifier().getText();
        LinkedList args = node.getExpression();
        // TODO get correct func definition from symbol table
        // Check that input arguments matches expected types
        super.inAFunctionCall(node);
    }
    // TODO get expected types of function call arguments
    // TODO get expected types of function return values (if they have) what do we do when they do not return anything though

    public static void showError(int line , int col , String message){
        System.out.printf("[%d,%d] %s%n" , line , col , message);
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
        // if right is function call expression and ret type is not number show error

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

}