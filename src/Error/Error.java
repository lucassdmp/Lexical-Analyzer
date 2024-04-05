package Error;

import Tools.Function;
import Util.Position;

@SuppressWarnings("serial")
public class Error extends Exception{
    public Position posStart;
    public Position posEnd;
    public String errorName;
    public String details;

    public Error(Position posStart, Position posEnd, String errorName, String details){
        this.posStart = posStart;
        this.posEnd = posEnd;
        this.errorName = errorName;
        this.details = details;
    }

    @Override
    public String toString(){
        String response = this.errorName + ": " + this.details + "\n";
        response += "In line: " + this.posStart.line + 1;
        response += "\n\n" + Function.StringPosition(posStart.txt, posStart, posEnd); 
        return response;
    }    
}
