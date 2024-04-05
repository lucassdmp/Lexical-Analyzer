package Error;

import Util.Position;

@SuppressWarnings("serial")
public class CharacterError extends Error{
    public CharacterError(Position posStart, Position posEnd, String details){
        super(posStart, posEnd, "Lexical Error: Illigal character\n", details);
    }
}
