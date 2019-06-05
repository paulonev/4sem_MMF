package by.bsu.handling.chain;

import by.bsu.handling.composite.*;

public class LexemeHandler implements BaseHandler {

    private Composite lexeme;

    public LexemeHandler() {
        lexeme = new Composite(CompositeType.LEXEME);
    }

    // splits lexemes on leaves - LETTER(\w), SYMBOL(if not letter)//[0-9_A-Za-z]

    /**
     * This method accepts portion of string between two spaces and creates lexeme of it
     * @param text  a portion of a string
     * @return      new lexeme
     */
    @Override
    public Component handleText(String text) {
        for (int i = 0; i < text.length(); i++) {
            String s = String.valueOf(text.charAt(i));
            Leaf leaf;
            if (s.matches("\\w")) {
                leaf = new Leaf(s, LeafType.LETTER);
            } else {
                leaf = new Leaf(s, LeafType.SYMBOL);
            }
            lexeme.addComponent(leaf);
        }
        return lexeme;
    }
}
