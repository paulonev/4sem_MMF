package handler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileReader {
    public List<String> readFromFile(String filePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        scanner = new Scanner(new FileReader(filePath));
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine(); //save line
            lines.add(str);
        }
        return lines;
    }
}
