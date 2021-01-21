import minipython.lexer.Lexer;
import minipython.node.Start;
import minipython.parser.Parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.nio.file.*;

public class ParserTest3
{
  public static void main(String[] args)
  {
    // Input is a directory containing test cases
    int numExceptions = 0;
    int numErrors = 0;
    int numCorrect = 0;
    String dirname = args[0];
    Path dir = Paths.get(dirname);
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
      for (Path file: stream) {
        // Run the symbol table and type checker for every file in the directory
        int result = runForFile(file.toString());
        System.out.print("Running compiler for " + file.getFileName()+ " ... ");

        if (result == 0){
          System.out.println("Compiler detected no errors");
          numCorrect++;
        }
        if (result == 1){
          System.out.println("Error found");
          numErrors++;
        }
        if (result == 2){
          System.out.println("Exception occured");
          numExceptions++;
        }
      }
    } catch (IOException | DirectoryIteratorException x) {
      // IOException can never be thrown by the iteration.
      // In this snippet, it can only be thrown by newDirectoryStream.
      System.err.println(x);
    }
    System.out.println("Num errors "  + numErrors );
    System.out.println("Num correct "  + numCorrect );
    System.out.println("Num Exceptions "  + numExceptions );
  }

  public static int runForFile(String file){
    // Returns 0 if no error occured
    // Returns 1 if type checker or symbol table returned an error
    // Returns 2 if an exception occurred
    try
    {
      Parser parser =
              new Parser(
                      new Lexer(
                              new PushbackReader(
                                      new FileReader(file), 1024)));

      Start ast = parser.parse();
      System.out.println("Applying symbol table");
      SymbolTable s = new SymbolTable();
      ast.apply(s);
      if (s.hasError){
        System.err.println("Symbol table has error... terminating");
        return 1;
      }
      System.out.println("Applying type checker");
      TypeChecker tc = new TypeChecker(s);
      ast.apply(tc);
      if (tc.hasError){
        System.err.println("Symbol table has error... terminating");
        return 1;
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
      return 2;
    }
    return 0;
  }
}

