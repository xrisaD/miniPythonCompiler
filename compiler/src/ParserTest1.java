import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.Start;

public class ParserTest1
{
  public static void main(String[] args)
  {
    try
    {
      Parser parser =
        new Parser(
        new Lexer(
        new PushbackReader(
        new FileReader(args[0].toString()), 1024)));

      Start ast = parser.parse();
      System.out.println("Applying symbol table");
      SymbolTable s = new SymbolTable();
      ast.apply(s);
      System.out.println("Applying apapter");
      ast.apply(new MyApapter(s));

    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}

