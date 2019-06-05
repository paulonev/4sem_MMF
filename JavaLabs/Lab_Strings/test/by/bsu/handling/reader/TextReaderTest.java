package by.bsu.handling.reader;

import org.junit.Assert;
import org.junit.Test;

public class TextReaderTest extends TextReader {
    private static final String FILE_PATH = "input/myExample.txt";
    private static final String EXPECTED_TEXT = "hello worLd.\nmy name is paul!\nwwwwwwwwww.     wwwwwwwwwwwwwwwwwww";

    @Test
    public void readFromFile() {
        TextReader tr = new TextReader();
        String actual = tr.readFromFile(FILE_PATH);
        Assert.assertEquals("Output:\n" + actual + "\nis not what expected:\n" + EXPECTED_TEXT, EXPECTED_TEXT, actual);
    }

}