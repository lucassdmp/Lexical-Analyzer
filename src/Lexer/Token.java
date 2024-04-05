package Lexer;

import Util.Node;
import Util.Position;
import Error.Error;

public class Token extends Node {
    public String type;
    public String value;

    public Token(String type) {
        this(type, null, null, null, null);
    }

    public Token(String type, String value) {
        this(type, value, null, null, null);
    }

    public Token(String type, String value, Position posStart) {
        this(type, value, posStart, null, null);
    }

    public Token(String type, String value, Position posStart, Position posEnd, Error error) {
        this(type, value, posStart, posEnd);
        this.error = error;
    }

    public Token(String type, String value, Position posStart, Position posEnd) {
        this.type = type;
        this.value = value;

        if (this.posStart != null) {
            this.posStart = posStart.copy();
            this.posEnd = posEnd.copy();
            this.posEnd.advance();
        }

        if (this.posEnd != null) {
            this.posEnd = posEnd.copy();
        }
    }

    public boolean stringMatches(String type, String value) {
        return this.type.equals(type) && this.value.equals(value);
    }

    @Override
    public String toString() {
        if(this.value != null){
            return this.type + ": " + this.value;
        }
        return this.type;
    }
}
