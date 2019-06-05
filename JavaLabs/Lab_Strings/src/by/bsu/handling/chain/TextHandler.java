package by.bsu.handling.chain;

import by.bsu.handling.composite.Component;
import by.bsu.handling.composite.Composite;
import by.bsu.handling.composite.CompositeType;
import by.bsu.handling.reader.RegexConstants;

public class TextHandler implements BaseHandler {
    private Composite textComposite;

    public TextHandler() {
        textComposite = new Composite(CompositeType.TEXT);
    }

    @Override
    public Component handleText(String text) {
        //разбитие текста на параграфы ( в том случае, если между символами есть 4 и более пробелов
        String[] paragraphs = text.split(RegexConstants.PARAGRAPH_REGEX);
        for (String line : paragraphs) {
            textComposite.addComponent(new ParagraphHandler().handleText(line));
        }
        return textComposite;
    }


}
