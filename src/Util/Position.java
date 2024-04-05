package Util;

public class Position implements Cloneable{
    public int Id;
    public int line;
    public int column;
    public String txt;

    public Position(int Id, int line, int column, String txt){
        this.Id = Id;
        this.line = line;
        this.column = column;
        this.txt = txt;
    }

    public Position advance(){
        return advance(null);
    }

    public Position advance(Character currentCharacter){
        this.column++;
        this.Id++;
        if(currentCharacter != null){
            if(currentCharacter == '\n'){
                this.line++;
                this.column = 0;
            }
        }
        return this;
    }

    public Position copy(){
        return new Position(this.Id, this.line, this.column, this.txt);
    }

    public Object clone(){
        return this.copy();
    }

    @Override
    public String toString(){
        return "Id: " + this.Id + " Line: " + this.line + " Column: " + this.column + " Text: " + this.txt;
    }
}