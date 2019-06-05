package by.bsu.handling.action;

import by.bsu.handling.chain.TextHandler;
import by.bsu.handling.composite.Component;
import by.bsu.handling.composite.Composite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextAction{
    private static final Logger LOGGER = LogManager.getLogger(TextAction.class);

    private TextAction() {
    }

    // TASK
    // Print first Num characters that appear most in the text

    /**This method creates composite from the text and calls printLeaf()
     * for composite
     *
     * @param text      text from the file
     * @param num       amount of symbols to choose
     * @return          function which collects that symbols
     */
    public static String printLeafs(String text, int num){
        if (text == null) {
            LOGGER.log(Level.WARN, "Can't do printLeafs with null input.");
            return "No data";
        }
        Composite paragraphs = (Composite) new TextHandler().handleText(text);
        return printLeafs(paragraphs, num);
    }

    private static String printLeafs(Composite composite, int num){
        if (composite == null) {
            LOGGER.log(Level.WARN, "Can't do printLeafs with null input.");
            return "No data";
        }

        List results = new ArrayList(getSortedHashMap(composite).entrySet());
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        for(i=0; i<num-1; i++){
            stringBuilder.append(results.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(results.get(i));
        return stringBuilder.toString();
    }

    /**This method is used to find the most often appeared symbol in text
     *
     * @param text      given text
     * @return          calls function that returns sorted by value() HashMap of "Symbol" - "Amount"
     */
    public static Map<String,Integer> findPopularLeaf(String text) {
        if (text == null) {
            LOGGER.log(Level.WARN, "Can't do printLeafs with null input.");
            return null;
        }
        Composite paragraphs = (Composite) new TextHandler().handleText(text);
        return findPopularLeaf(paragraphs);
        //на основе текста создаётся массив параграфов (compositeType = PARAGRAPH)
        //на основе каждого параграфа создаётся массив предложений (componentType = SENTENCE)
        //на основе каждого предложения создаётся массив лексем (componentType = LEXEME)
        //на основе каждой лексемы создаётся массив символов (componentType = SYMBOL)

    }

    private static Map<String, Integer> findPopularLeaf(Composite paragraphs) {
        if (paragraphs == null) {
            LOGGER.log(Level.WARN, "Can't do printLeafs with null input.");
            return null;
        }
        return getSortedHashMap(paragraphs);
    }

    /**This method accepts paragraphs that contains sentences that contain lexemes that contain leafs.
     * And creates a sorted Map "Symbol" - "Amount" that shows how often symbols appear in the text
     *
     * @param composite     nested object
     * @return              sorted Map
     */
    private static Map<String, Integer> getSortedHashMap(Composite composite){
        Map<String, Integer> result = new LinkedHashMap<>();

        HashMap<String, Integer> hm = makeHashMap(composite);

        hm.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }


    /**This method creates HashMap with all symbols of given text
     * HashMap : "symbol" - "amount of appearances"
     *
     * @param paragraphs    given text
     * @return              HashMap of symbols
     */
    private static HashMap<String, Integer> makeHashMap(Composite paragraphs) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (Component par : paragraphs.getComponents()) {
            Composite sentences = (Composite) par;
            for (Component sentence : sentences.getComponents()) {
                Composite lexemes = (Composite) sentence;
                for (Component lexeme : lexemes.getComponents()){
                    Composite leafs = (Composite) lexeme;
                    for (Component leaf : leafs.getComponents()){
                        String leafStr = leaf.toString();
                        if (hm.get(leafStr) != null) {
                            int temp = hm.get(leafStr); //how many values of key we have
                            hm.put(leafStr, ++temp); //add new number of values of that key
                        } else {
                            hm.put(leafStr, 1);
                        }
                    }
                }
            }
        }
        return hm;
    }

}