import Lexer.Lexer;
import Lexer.LexerOut;
import Tools.Function;
import Error.Error;

public class App {
    public static String prompt = ">>> ";

    public static LexerOut run(String string) {
        Lexer lexer = new Lexer(string);
        LexerOut lexerOut = lexer.makeTokens();
        if (lexerOut.error != null) {
            return new LexerOut(null, lexerOut.error);
        }
        return lexerOut;
    }

    public static void main(String[] args) throws Exception {
        String line = Function.shell(prompt).trim();
        while(line != ":q"){
            LexerOut lexerOut = run(line);
            if(lexerOut.error != null){
                System.out.println(lexerOut);
            }else{
                System.out.println(lexerOut);
            }
            line = Function.shell(prompt).trim();
        }
    }
}
