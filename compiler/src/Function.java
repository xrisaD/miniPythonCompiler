import java.util.Objects;

class Function {
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
