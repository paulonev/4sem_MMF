package handler;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileWriter {
    private static final Logger LOGGER = LogManager.getLogger(fileWriter.class.getName());

    public void writeInFile(List<String> lines){
        try {
            FileWriter fw = null;
            fw = new FileWriter("data\\textNew.txt");
            for (String line : lines){
                fw.write(line);
                fw.write("\n");
            }

            fw.close();

        } catch (IOException ex){
            LOGGER.log(Level.ERROR, "Error with fileWriter stream");
        }
    }
}
