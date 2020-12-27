import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;

import java.util.*;
import java.util.concurrent.Callable;

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