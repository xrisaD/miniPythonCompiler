import java.util.Objects;

class FunctionCall {
    String name;
    int line;
    int column;
    int numArgs;


    public FunctionCall(String name, int line, int column, int numArgs) {
        this.name = name;
        this.line = line;
        this.column = column;
        this.numArgs = numArgs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionCall that = (FunctionCall) o;
        return line == that.line &&
                column == that.column &&
                numArgs == that.numArgs &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, line, column, numArgs);
    }
}
