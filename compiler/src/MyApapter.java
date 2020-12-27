import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.*;

public class MyApapter extends DepthFirstAdapter
{
    // variables: defined variables
    // fcall: called functions
    // fdef: defined functions
    private Hashtable<String, Variable> variables;
    private Hashtable<String, Function> fcall;
    private Hashtable<String, Function> fdef;

    MyApapter()
    {
        this.variables = new Hashtable<String, Variable>();
        this.fcall = new Hashtable<String, Function>();
        this.fdef = new Hashtable<String, Function>();
    }

    @Override
    public void inAFunction(AFunction node) {
       String fname = node.getIdentifier().getText();
       int line = node.getIdentifier().getLine();
       int pos = node.getIdentifier().getPos();

       Function newFunDef = new Function(fname, line, pos);
       fdef.put(fname, newFunDef);
    }

    @Override
    public void inAFunctionCall(AFunctionCall node) {
        String fname = node.getIdentifier().getText();
        int line = node.getIdentifier().getLine();
        int pos = node.getIdentifier().getPos();

        Function newFunCall = new Function(fname, line, pos);
        fcall.put(fname, newFunCall);
    }

    @Override
    public void outStart(Start node) {
        for (String k: fcall.keySet()) {
            if(fdef.get(k)==null){
                Function funcCall = fcall.get(k);
                System.out.println("Undefined function in line "+funcCall.line);
            }
        }
    }

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

    // type checks
    @Override
    public void outASumExpression(ASumExpression node) {
        var e1 = node.getE1();
        var e2 = node.getE2();
        if (e1 instanceof ATypeExpression ||
            e1 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }

        }
        // Same for e2
        if (e2 instanceof ATypeExpression ||
                e2 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }
        }
    }

    @Override
    public void outAMultExpression(AMultExpression node) {
        var e1 = node.getE1();
        var e2 = node.getE2();
        if (e1 instanceof ATypeExpression ||
                e1 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }

        }
        // Same for e2
        if (e2 instanceof ATypeExpression ||
                e2 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }
        }
    }

    @Override
    public void outAPowExpression(APowExpression node) {
        var e1 = node.getE1();
        var e2 = node.getE2();
        if (e1 instanceof ATypeExpression ||
                e1 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }

        }
        // Same for e2
        if (e2 instanceof ATypeExpression ||
                e2 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }
        }
    }

    @Override
    public void outADivExpression(ADivExpression node) {
        var e1 = node.getE1();
        var e2 = node.getE2();
        if (e1 instanceof ATypeExpression ||
                e1 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }

        }
        // Same for e2
        if (e2 instanceof ATypeExpression ||
                e2 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }
        }
    }

    @Override
    public void outAMinusExpression(AMinusExpression node) {
        var e1 = node.getE1();
        var e2 = node.getE2();
        if (e1 instanceof ATypeExpression ||
                e1 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }

        }
        // Same for e2
        if (e2 instanceof ATypeExpression ||
                e2 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }
        }
    }

    @Override
    public void outAModuloExpression(AModuloExpression node) {
        var e1 = node.getE1();
        var e2 = node.getE2();
        if (e1 instanceof ATypeExpression ||
                e1 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e1 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e1;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }

        }
        // Same for e2
        if (e2 instanceof ATypeExpression ||
                e2 instanceof AOpenExpression ){
            System.out.println("Numeric expression cannot have type or open operands ");
        }
        if (e2 instanceof AValueExpression){
            AValueExpression v1 = (AValueExpression) e2;
            if (v1.getValue() instanceof ANoneValue){
                System.out.println("Numeric expression cannot have None operands ");
            }
        }
    }

    public static String getExpressionType(PExpression expr){
        if (expr instanceof ASumExpression){
            return "number";
        }
        if (expr instanceof AMinusExpression){
            return "number";
        }
        if (expr instanceof AMultExpression){
            return "number";
        }
        if (expr instanceof ADivExpression){
            return "number";
        }
        if (expr instanceof APowExpression){
            return "number";
        }
        if (expr instanceof AModuloExpression){
            return "number";
        }
        // Value case
        if (expr instanceof AValueExpression){
            PValue val = ((AValueExpression) expr).getValue();
            if (val instanceof AStringValue){
                return "string";
            }
            if (val instanceof ANumberValue){
                return "number";
            }
            if (val instanceof ANoneValue){
                return "none";
            }
            if (val instanceof AMethodValue){
                PFunctionCall f = ((AMethodValue) val).getFunctionCall();
                if (f instanceof AFunctionCall){
                    String function_name = ((AFunctionCall) f).getIdentifier().getText();
                    // TODO get function ret type
                }
            }
        }
        if (expr instanceof AListDefExpression){
            return "list";
        }
        if (expr instanceof AIdentifierExpression){
            String identifierName =  ((AIdentifierExpression) expr).getIdentifier().getText();
            // TODO get identifier type
        }
        return "UNDEFINED!!!";
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

        public Function(String name, int line, int column) {
            this.name = name;
            this.line = line;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Function function = (Function) o;
            return Objects.equals(name, function.name) &&
                    Objects.equals(line, function.line) &&
                    Objects.equals(column, function.column);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, line, column);
        }
    }
}