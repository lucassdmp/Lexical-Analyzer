package Lexer;

import java.util.ArrayList;
import java.util.Iterator;

import Error.Error;

public class LexerOut {
    public ArrayList<Token> tokens;
    public Error error;

    public LexerOut(ArrayList<Token> tokens, Error error) {
        this.tokens = tokens;
        this.error = error;
    }
    
    public LexerOut(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.error = null;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("[");
        if (tokens != null) {
            Iterator<Token> it = tokens.iterator();
            if (it.hasNext()) {
                buffer.append(it.next().toString());
            }
            while (it.hasNext()) {
                buffer.append(", ").append(it.next().toString());
            }
        }
        buffer.append("]");
        if (error != null) {
            buffer.append("\n").append(error.toString());
        }
        return buffer.toString();
    }
}
