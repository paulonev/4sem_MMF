package by.bsu.handling.chain;

import by.bsu.handling.composite.Component;
import by.bsu.handling.composite.Composite;
import by.bsu.handling.composite.CompositeType;
import by.bsu.handling.parser.TextParser;
import by.bsu.handling.reader.RegexConstants;

import java.util.ArrayList;

public class SentenceHandler implements BaseHandler {
    private Composite sentence;

    public SentenceHandler() {
        sentence = new Composite(CompositeType.SENTENCE);
    }

    // splits sentence on lexemes
    // split regex: \s+ //пробельные символы  один или более раз
    // checks if lexeme includes math expression
    // and replaces math expression with its result

    /**
     * This method accepts paragraph and creates sentence that is located in it
     * Important to notice that this method applies chain pattern
     * It means that when unresolved paragraph (not divided into small parts) comes to this method, method
     * delegates it to LexemeHandler() to divide sentence into lexemes first and then add lexemes to sentence
     * @param text  a portion of text
     * @return      new sentence
     */
    @Override
    public Component handleText(String text) {
        //System.out.println("Handle sentence");

        ArrayList<String> lexemes = TextParser.parseText(text,RegexConstants.LEXEME_SPLITERATOR);
        for (String line : lexemes) {
            sentence.addComponent(new LexemeHandler().handleText(line)); //create lexem and append to sentence
        }
        return sentence;

    }
}