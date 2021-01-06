import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.ArrayList;

/**
 * Class that has an input a set of variable names and returns their expected types in a statement
 */
public class TypeFinder extends DepthFirstAdapter {
    ArrayList<String> varNames;
    ArrayList<String> expectedTypes;

    public TypeFinder(ArrayList<String> varNames) {
        this.varNames = varNames;
        expectedTypes = new ArrayList<String>();
        for (int i = 0 ; i < varNames.size(); i ++){
            expectedTypes.add("any");
        }
    }

    @Override
    public void outAArithmeticExpression(AArithmeticExpression node) {
        PExpression e1 = node.getE1();
        PExpression e2 = node.getE2();
        if (e1 instanceof AIdentifierExpression){
            String varName = ((AIdentifierExpression) e1).getIdentifier().getText();
            if (varNames.contains(varName)){
                int idx = varNames.indexOf(varName);
                expectedTypes.set(idx , "number");
            }

        }
        if (e2 instanceof AIdentifierExpression){
            String varName = ((AIdentifierExpression) e2).getIdentifier().getText();
            if (varNames.contains(varName)){
                int idx = varNames.indexOf(varName);
                expectedTypes.set(idx , "number");
            }

        }
    }
    ArrayList<String> getExpectedTypes(){
        return expectedTypes;
    }
}
