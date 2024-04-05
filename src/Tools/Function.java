package Tools;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Util.Position;

public class Function {
    public static boolean contains(String[] arr, String targetValue) {
        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }

    public static boolean contains(String string, Character targetCharacter){
        for(Character c : string.toCharArray()){
            if(c.equals(targetCharacter))
                return true;
        }
        return false;
    }

    public static boolean contains(String key, String value, TupleKeyValue<String, String>[] tuples){
        for(TupleKeyValue<String, String> tuple : tuples){
            if(tuple.key.equals(key) && tuple.value.equals(value))
                return true;
        }
        return false;
    }

    public static String StringPosition(String targetString, Position posStart, Position posEnd){
        String result = "";
        
        int idStart = 0;
        try{
            idStart = Math.max(targetString.lastIndexOf('\n'), 0);
        }catch(Exception e){
            idStart = 0;
        }

        int idEnd = targetString.indexOf('\n', idStart + 1);

        if(idEnd < 0)
            idEnd = targetString.length();

        int lineCount = posEnd.line - posStart.line + 1;

        for(int i = 0; i < lineCount; i++){
            String line = targetString.substring(idStart, idEnd - idStart);

            int colStart = i == 0 ? posStart.column : 0;
            int colEnd = i == lineCount - 1 ? posEnd.column : line.length() - 1;

            result += line + "\n";
            String space = "", space2 = "";
            for(int j = 0; j < colStart; j++){
                space += " ";
            }
            for(int j = colStart; j < colEnd; j++){
                space2 += "^";
            }
            result += space + space2;

            idStart = idEnd;

            try{
                idEnd = targetString.indexOf('\n', idStart + 1);
            } catch(Exception e){
                if(idEnd < 0)
                    idEnd = targetString.length();
            }
        }
        return result.replace("\t", "");
    }

    public static String shell(String prompt){
        System.out.println(prompt+" ");
        String message = "Warn: Shell function can't read input keyboard!";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            message = reader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return message;
    }
}
