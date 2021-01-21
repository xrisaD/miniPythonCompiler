import minipython.node.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class FunctionDefinition {
    String name;
    int line;
    int col;

    // Minimum number of arguments ( excluding default args )
    int sum;
    // Maximum number of arguments ( including default args )
    int total;

    ArrayList<AIdentifierValue> identifierValues;
    PStatement statement;

    String retType;
    // The functionDefinition object that is returned (if its returned)
    FunctionDefinition retDef;
    PFunctionCall retFuncCall;
    ArrayList<String> expectedTypes;


    public FunctionDefinition(String name, int line, int col, int sum, int total) {
        this.name = name;
        this.line = line;
        this.col = col;
        this.sum = sum;
        this.total = total;
    }

    /**
     * Returns true if the current function is a redefinition of @param other
     * @param other the other function
     */
    public boolean redefines(FunctionDefinition other){
        // True iff if there is an overlap on the range of parameters that can be called with the function
        if (sum <= other.sum){
            return total >= other.sum;
        }
        else return other.total >= this.sum;
    }

    /**
     * Returns trye if the function call can be called with this function definition
     * @param call
     * @return
     */
    public boolean matches(FunctionCall call){
        return call.numArgs >= sum && call.numArgs <= total;
    }


    public ArrayList<String> getExpectedTypes() {
        return expectedTypes;
    }

    public void setExpectedTypes(ArrayList<String> expectedTypes) {
        this.expectedTypes = expectedTypes;
    }
    public void setIdentifierValues(ArrayList<AIdentifierValue> identifierValues) {
        this.identifierValues = identifierValues;
    }

    public void setStatement(PStatement statement) {
        // If any argument is used in a arithmetic expression the expected type is number
        // id the argument is not used anywhere the expected type is 'any'
        this.statement = statement;
        if (statement instanceof AReturnStatement){
            AReturnStatement ret = (AReturnStatement) statement;
            PExpression expr =  ret.getExpression();
            if (expr instanceof AArithmeticExpression){
                retType = "number";
                return;
            }
            if (expr instanceof AFuncCallExpression){
                retType = "to_be_decided";
                retFuncCall = ((AFuncCallExpression) expr).getFunctionCall();
                return;
            }
            if (expr instanceof AValueExpression){
                if(((AValueExpression) expr).getValue() instanceof AMethodValue){
                    retFuncCall = ((AMethodValue) ((AValueExpression) expr).getValue()).getFunctionCall();
                    retType = "to_be_decided";
                    return;
                }
            }
        }
        //if its if statement void can be returned
        //while behaves like if statement
        //for behaves like if statement
        //func call returns void
        retType = "void";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionDefinition that = (FunctionDefinition) o;
        return sum == that.sum &&
                total == that.total &&
                Objects.equals(name, that.name) &&
                Objects.equals(line, that.line) &&
                Objects.equals(col, that.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, line, col, sum, total);
    }

    /**
     * Returns the function definition object of the function call if it is returned by the function
     */
    public FunctionDefinition getReturnDef(){
        return retDef;
    }
}
