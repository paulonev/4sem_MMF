import handler.fileReader;
import handler.fileWriter;
import handler.stringReverser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;


/**This is the main operating class of the program.
 * Here we will perform what we are asked to do:
 *
 * Task10. Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
 */
public class MainRunner {
    //our file
    private static final Logger LOGGER = LogManager.getLogger(MainRunner.class.getName());
    private static String filePath = "data\\text.txt";

    /**As far as we work with symbol files (not byte)
     * We can use classes Reader or Scanner to extract data from the file
     */
    public static void main(String[] args){
        fileReader fr = new fileReader();
        fileWriter fw = new fileWriter();
        stringReverser sr = new stringReverser();
        try {
            fw.writeInFile(sr.reverseStrings(fr.readFromFile(filePath)));
        } catch(FileNotFoundException filex) {
            LOGGER.log(Level.ERROR, "Unfortunately, couldn't find the file.");
        }
    }
}
