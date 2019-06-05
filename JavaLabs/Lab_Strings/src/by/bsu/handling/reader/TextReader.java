package by.bsu.handling.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader {
    static final Logger LOGGER = LogManager.getLogger(TextReader.class.getName());

    public String readFromFile(String path)
    {
        List<String> lines;
        StringBuilder sb = new StringBuilder();
        try
        {
            lines = Files.readAllLines(Paths.get(path));
            for (int i=0;i<lines.size()-1;i++)
            {
                sb.append(lines.get(i));
                sb.append("\n");
            }
            sb.append(lines.get(lines.size()-1));
            return sb.toString();
        }
        catch (IOException e)
        {
            LOGGER.fatal("Can't the input file for read!");
            throw new RuntimeException("No input information!");
        }
    }
}
