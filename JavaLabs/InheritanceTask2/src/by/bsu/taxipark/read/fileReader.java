package by.bsu.taxipark.read;

import by.bsu.taxipark.entity.Auto;
import by.bsu.taxipark.entity.fewPassengersCar.CarClassification;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class fileReader {
    private static final Logger LOGGER = LogManager.getLogger(fileReader.class);

    public static ArrayList<String> readFile(String filePath) throws RuntimeException{
        ArrayList<String> strings = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
            return strings;
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException("Couldn't find the file");
        } finally {
            scanner.close();
        }
    }

}
