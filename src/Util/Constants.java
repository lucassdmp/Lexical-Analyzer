package Util;

public final class Constants {
    public static final String DIGITS = "0123456789";
    public static final String LETTERS_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String LETTERS_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTERS = LETTERS_LOWER + LETTERS_UPPER;
    public static final String LETTERS_DIGITS = LETTERS + DIGITS;

    //Data types
    public static final String INT = "INT"; //Integer
    public static final String FLOAT = "FLOAT"; //Float
    public static final String BOOL = "BOOL"; //Boolean
    public static final String STRING = "STRING"; //String
    public static final String CHAR = "CHAR"; //Character
    public static final String VOID = "VOID"; //Void (no return type)

    //Boolean
    public static final String TRUE = "TRUE"; //True
    public static final String FALSE = "FALSE"; //False
    public static final String NULL = "NULL"; //Null


    public static final String ID = "ID"; //Identifier
    public static final String KEYWORD = "KEYWORD"; //Keyword
    public static final String DATATYPE = "DATATYPE"; //Data type

    //Operators
    public static final String PLUS = "PLUS"; //Addition: +
    public static final String MINUS = "MINUS"; //Subtraction: -
    public static final String MUL = "MUL"; //Multiplication: *
    public static final String DIV = "DIV"; //Division: /
    public static final String MOD = "MOD"; //Modulus: %
    public static final String POW = "POW"; //Power: ^
    public static final String EQ = "EQ"; //Equal: ==
    public static final String NE = "NE"; //Not equal: !=
    public static final String LT = "LT"; //Less than: <
    public static final String LE = "LE"; //Less than or equal: <=
    public static final String GT = "GT"; //Greater than: >
    public static final String GE = "GE"; //Greater than or equal: >=
    public static final String AND = "AND"; //Logical AND: &&
    public static final String OR = "OR"; //Logical OR: ||
    public static final String NOT = "NOT"; //Logical NOT: !
    public static final String ASSIGN = "ASSIGN"; //Assignment: =
    public static final String INC = "INC"; //Increment: ++
    public static final String DEC = "DEC"; //Decrement: --
    public static final String ADD_ASSIGN = "ADD_ASSIGN"; //Addition assignment: +=
    public static final String SUB_ASSIGN = "SUB_ASSIGN"; //Subtraction assignment: -=
    public static final String MUL_ASSIGN = "MUL_ASSIGN"; //Multiplication assignment: *=
    public static final String DIV_ASSIGN = "DIV_ASSIGN"; //Division assignment: /=

    //Delimiters
    public static final String COMMA = "COMMA"; //Comma: ,
    public static final String LPAREN = "LPAREN"; //Left parenthesis: (
    public static final String RPAREN = "RPAREN"; //Right parenthesis: )
    public static final String LBRACE = "LBRACE"; //Left brace: {
    public static final String RBRACE = "RBRACE"; //Right brace: }
    public static final String LBRACKET = "LBRACKET"; //Left bracket: [
    public static final String RBRACKET = "RBRACKET"; //Right bracket: ]
    public static final String SEMICOLON = "SEMICOLON"; //Semicolon: ;
    public static final String COLON = "COLON"; //Colon: :
    public static final String NEWLINE = "NEWLINE"; //Newline: \n
    public static final String EOF = "EOF"; //End of file

    //Keywords
    public static final String VAR = "VAR"; //Variable declaration: var
    public static final String IF = "IF"; //If statement: if
    public static final String ELSE = "ELSE"; //Else statement: else
    public static final String WHILE = "WHILE"; //While loop: while
    public static final String FOR = "FOR"; //For loop: for
    public static final String FUNC = "FUNC"; //Function declaration: func
    public static final String RETURN = "RETURN"; //Return statement: return

    //Comments
    public static final String COMMENT = "COMMENT"; //Comment: #



    public static final String[] KEYWORDS = new String[RESERVEDID.SIZE_KEY];
    public static final String[] EMBEDDED = new String[RESERVEDID.SIZE_EMB];
    public static final String[] DATATYPES = new String[RESERVEDID.SIZE_OP];
    static{
        KEYWORDS[RESERVEDID.VAR] = VAR.toLowerCase();
        KEYWORDS[RESERVEDID.IF] = IF.toLowerCase();
        KEYWORDS[RESERVEDID.ELSE] = ELSE.toLowerCase();
        KEYWORDS[RESERVEDID.WHILE] = WHILE.toLowerCase();
        KEYWORDS[RESERVEDID.FOR] = FOR.toLowerCase();
        KEYWORDS[RESERVEDID.FUNC] = FUNC.toLowerCase();
        KEYWORDS[RESERVEDID.RETURN] = RETURN.toLowerCase();

        EMBEDDED[RESERVEDID.FALSE] = FALSE.toLowerCase();
        EMBEDDED[RESERVEDID.TRUE] = TRUE.toLowerCase();
        EMBEDDED[RESERVEDID.NULL] = NULL.toLowerCase();

        DATATYPES[RESERVEDID.INT] = INT.toLowerCase();
        DATATYPES[RESERVEDID.FLOAT] = FLOAT.toLowerCase();
        DATATYPES[RESERVEDID.BOOL] = BOOL.toLowerCase();
        DATATYPES[RESERVEDID.STRING] = STRING.toLowerCase();
        DATATYPES[RESERVEDID.CHAR] = CHAR.toLowerCase();
        DATATYPES[RESERVEDID.VOID] = VOID.toLowerCase();
    }


    public static class RESERVEDID{
        public static final int SIZE_KEY = 7, SIZE_EMB = 3, SIZE_OP = 6;

        //Reserved keywords
        public static final int VAR = 0;
        public static final int IF = 1;
        public static final int ELSE = 2;
        public static final int WHILE = 3;
        public static final int FOR = 4;
        public static final int FUNC = 5;
        public static final int RETURN = 6;

        
        //Reserved symbols
        public static final int FALSE = 0;
        public static final int TRUE = 1;
        public static final int NULL = 2; 

        //Data types
        public static final int INT = 0;
        public static final int FLOAT = 1;
        public static final int BOOL = 2;
        public static final int STRING = 3;
        public static final int CHAR = 4;
        public static final int VOID = 5;



    }


}
