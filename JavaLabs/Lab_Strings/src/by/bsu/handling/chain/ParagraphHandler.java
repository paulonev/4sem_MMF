package by.bsu.handling.chain;

import by.bsu.handling.composite.Component;
import by.bsu.handling.composite.Composite;
import by.bsu.handling.composite.CompositeType;
import by.bsu.handling.parser.TextParser;
import by.bsu.handling.reader.RegexConstants;

import java.util.ArrayList;

public class ParagraphHandler implements BaseHandler {

    private Composite paragraph;

    public ParagraphHandler() {
        paragraph = new Composite(CompositeType.PARAGRAPH);
    }

    // splits paragraph on sentences
    // pattern regex: (?:[^!?.]|\.(?=\d))+[!?.]

    //"(?:[^!?.]|\\.(?=\\d))незахватываемая группа: в начале строки нет символа конца предложения или точки, но есть цифры
    // +  //один или более раз
    // [!?.]"  //символ конца предложения
    // предложение содержащее цифры
    @Override
    public Component handleText(String text) {
        //System.out.println("Handle paragraph");
        //разбитие параграфа на предложения, хранящиеся в ArrayList<String> sentences
        ArrayList<String> sentences = TextParser.parseText(text, RegexConstants.SENTENCE_REGEX);
        for (String line : sentences) {
            paragraph.addComponent(new SentenceHandler().handleText(line));
        }
        return paragraph;
    }
}
