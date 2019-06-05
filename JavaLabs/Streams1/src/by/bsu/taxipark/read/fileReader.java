package by.bsu.taxipark.read;

import java.io.*;
import java.util.*;

public class fileReader {

    public static ArrayList<String> readFile(String filePath) throws FileNotFoundException{
        ArrayList<String> strings = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            strings.add(scanner.nextLine());
        }
        return strings;
    }
}
