import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.Start;


public class ParserTest2Color
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

      ASTPrinter p = new ASTPrinter();
      p.setColor(true);

      ast.apply(p);
      System.out.println(ast);
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}

