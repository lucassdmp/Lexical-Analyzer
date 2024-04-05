package Lexer;

import java.util.ArrayList;

import Tools.Function;
import Util.Constants;
import Util.Position;
import Error.CharacterError;

public class Lexer {
    private char[] text;
    private Position position;
    private Character currentChar;

    public Lexer(String text) {
        this.text = text.toCharArray();
        this.position = new Position(-1, 0, -1, text);
        this.currentChar = null;
        this.Advance();
    }

    private void Advance() {
        this.position.advance(currentChar);
        this.currentChar = position.Id < text.length ? text[position.Id] : null;
    }

    public LexerOut makeTokens() {
        ArrayList<Token> tokens = new ArrayList<Token>();

        while (this.currentChar != null) {
            if (Function.contains(Constants.DIGITS, currentChar)) {
                tokens.add(this.makeNumber());
            } else if (Function.contains(Constants.LETTERS, currentChar)) {
                tokens.add(this.makeIdentifier());
            } else if (this.currentChar == '+') {
                tokens.add(new Token(Constants.PLUS, "+", position, null));
                this.Advance();
            } else if (this.currentChar == '-') {
                tokens.add(new Token(Constants.MINUS, "-", position, null));
                this.Advance();
            } else if (this.currentChar == '*') {
                tokens.add(new Token(Constants.MUL, "*", position, null));
                this.Advance();
            } else if (this.currentChar == '/') {
                tokens.add(new Token(Constants.DIV, "/", position, null));
                this.Advance();
            } else if (this.currentChar == '(') {
                tokens.add(new Token(Constants.LPAREN, "(", position, null));
                this.Advance();
            } else if (this.currentChar == ')') {
                tokens.add(new Token(Constants.RPAREN, ")", position, null));
                this.Advance();
            } else if (this.currentChar == '{') {
                tokens.add(new Token(Constants.LBRACE, "{", position, null));
                this.Advance();
            } else if (this.currentChar == '}') {
                tokens.add(new Token(Constants.RBRACE, "}", position, null));
                this.Advance();
            } else if (this.currentChar == ',') {
                tokens.add(new Token(Constants.COMMA, ",", position, null));
                this.Advance();
            } else if (this.currentChar == ':') {
                tokens.add(new Token(Constants.COLON, ":", position, null));
                this.Advance();
            } else if (this.currentChar == ';') {
                tokens.add(new Token(Constants.SEMICOLON, ";", position, null));
                this.Advance();
            } else if (this.currentChar == '!') {
                tokens.add(this.makeNotEqual());
            } else if (this.currentChar == '=') {
                tokens.add(this.makeEqual());
            } else if (this.currentChar == '<') {
                tokens.add(this.makeLesser());
            } else if (this.currentChar == '>') {
                tokens.add(this.makeGreater());
            } else if (this.currentChar == '"') {
                tokens.add(this.makeString());
            } else if (Function.contains(" \t", currentChar)) {
                this.Advance();
            } else if (this.currentChar == '#') {
                this.skipComment();
            } else if (Function.contains(";\n\r\n", currentChar)) {
                tokens.add(new Token(Constants.NEWLINE, "\n", position, null));
                this.Advance();
            } else if (this.currentChar == '"') {
                tokens.add(this.makeString());
            } else if (this.currentChar == 65279) {
                this.Advance();
            }else{
                Position start = this.position.copy();
                char char_ = this.currentChar;
                this.Advance();
                return new LexerOut(new ArrayList<Token>(), new CharacterError(start, this.position, "Character: " + char_ + " is not recognized"));            
            }
        }
        tokens.add(new Token(Constants.EOF, null, position, null));
        return new LexerOut(tokens);
    }

    private Token makeNotEqual() {
        Position start = this.position.copy();
        this.Advance();

        if (this.currentChar != null && this.currentChar == '=') {
            this.Advance();
            return new Token(Constants.NE, "!=", start, this.position);
        }

        return new Token(Constants.NOT, "!", start, this.position);
    }

    private Token makeEqual() {
        Position start = this.position.copy();
        this.Advance();

        if (this.currentChar != null && this.currentChar == '=') {
            this.Advance();
            return new Token(Constants.EQ, "==", start, this.position);
        }

        return new Token(Constants.ASSIGN, "=", start, this.position);
    }

    private Token makeIdentifier() {
        String idString = "";

        Position start = this.position.copy();

        while (this.currentChar != null && Function.contains(Constants.LETTERS_DIGITS, this.currentChar)) {
            idString += this.currentChar;
            this.Advance();
        }

        if(Function.contains(Constants.DATATYPES, idString)){
            return new Token(Constants.DATATYPE, idString, start, this.position);

        }else if (Function.contains(Constants.KEYWORDS, idString)) {
            return new Token(Constants.KEYWORD, idString, start, this.position);
        } else if (Function.contains(Constants.EMBEDDED, idString)) {
            if (idString.equals("true") || idString.equals("false")) {
                return new Token(Constants.BOOL, idString, start, this.position);
            }
        }

        return new Token(Constants.ID, idString, start, this.position);
    }

    private Token makeLesser() {
        Position start = this.position.copy();
        this.Advance();

        if (this.currentChar != null && this.currentChar == '=') {
            this.Advance();
            return new Token(Constants.LE, "<=", start, this.position);
        }

        return new Token(Constants.LT, "<", start, this.position);
    }

    private Token makeGreater() {
        Position start = this.position.copy();
        this.Advance();

        if (this.currentChar != null && this.currentChar == '=') {
            this.Advance();
            return new Token(Constants.GE, ">=", start, this.position);
        }

        return new Token(Constants.GT, ">", start, this.position);
    }

    private Token makeNumber() {
        String number = "";
        int dotCount = 0;

        Position start = this.position.copy();

        while (this.currentChar != null
                && (Function.contains(Constants.DIGITS, this.currentChar) || this.currentChar == '.')) {
            if (this.currentChar == '.') {
                if (dotCount == 1)
                    break;
                dotCount++;
                number += '.';
            } else {
                number += this.currentChar;
            }
            this.Advance();
        }

        if (dotCount == 0) {
            return new Token(Constants.INT, number, start, this.position);
        } else {
            return new Token(Constants.FLOAT, number, start, this.position);
        }
    }

    private Token makeString() {
        String string = "";
        Position start = this.position.copy();
        this.Advance();

        while (this.currentChar != null && this.currentChar != '"') {
            string += this.currentChar;
            this.Advance();
        }
        this.Advance();

        return new Token(Constants.STRING, string, start, this.position);
    }

    public void skipComment() {
        this.Advance();
        while (this.currentChar != '\n') {
            this.Advance();
        }
        this.Advance();
    }
}
