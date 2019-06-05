package handler;

import java.util.ArrayList;
import java.util.List;

public class stringReverser {
    public List<String> reverseStrings(List<String> lines){
        List<String> new_strings = new ArrayList<>();
        for(String line : lines){
            new_strings.add(line.replaceAll("([^.!?, ]+)([^\\/]+?)([^.!?, ]+)([\\/])", "$3$2$1$4"));
        }
        return new_strings;
    }
}
