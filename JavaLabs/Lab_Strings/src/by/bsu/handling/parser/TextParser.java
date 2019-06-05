package by.bsu.handling.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser{

    private TextParser() {
    }

    // returns empty list if any of parameters is null
    public static ArrayList<String> parseText(String text, String regex) {
        ArrayList<String> list = new ArrayList<>();

        if (text == null || regex == null) {
            return list;
        }

        Pattern p = Pattern.compile(regex);//разбивает, например, предложения на слова
        Matcher m = p.matcher(text);
        while (m.find()) {
            list.add(m.group().replaceAll("\\s+", " ").trim());//все подряд идущие пробельные символы заменяет пробелом, начальные и конечные пробелы отсекает
        }
        return list;
    }
}
