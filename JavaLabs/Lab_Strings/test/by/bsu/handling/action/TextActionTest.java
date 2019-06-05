package by.bsu.handling.action;

import by.bsu.handling.chain.TextHandler;
import by.bsu.handling.composite.Composite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TextActionTest {
    private static final Logger LOGGER = LogManager.getLogger(TextActionTest.class);
    private static final String filePath = "input/myExample.txt";

    /**In this method we will test two functions of this app:
     * 1)ability to create nested objects: text-paragraphs-sentences-lexemes-leafs
     * 2)does our special func printLeafs() from by.bsu.handling.action.TextAction perform
     * printing first N characters that appear most in text
     * In result we wanna check what is symbol with most appearances and how many appearances it has
     */
    @Test
    public void findLeaf() {
        try {
            String text = "Hello worlld!\nMy name is Paul." +
                    "    GOOGLE - is my favourite search engine";
            Map<String, Integer> expect = new LinkedHashMap<>();
            expect.put("l", 6); //check that letter l appears 6 times in text ( test failed because there are only 5 "l" )
            List expected = new ArrayList(expect.entrySet());

            List actual = new ArrayList(TextAction.findPopularLeaf(text).entrySet());
            Assert.assertEquals(expected.get(0), actual.get(0));
        } catch(IndexOutOfBoundsException e){
            LOGGER.log(Level.ERROR, "Not able to find N unique symbols in text\n");
        }
    }

    /**The purpose of this method is to check how printLeafs() works
     * to show first N symbols that appear most in the given text
     */
    @Test
    public void printLeafs(){
        try {
            final int N = 6;
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder(1024);
            for (String line : lines) {
                sb.append(line);
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            String fromFile = sb.toString();

            LOGGER.log(Level.INFO, "Symbols that appear most in text: " + TextAction.printLeafs(fromFile, N));
        } catch(IOException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        } catch(IndexOutOfBoundsException e){
            LOGGER.log(Level.ERROR, "Not able to find N unique symbols in text\n");
        }
    }

    /**The purpose of this method is to check how printLeafs() works
     * to show first N symbols that appear most in the given text
     */
    @Test
    public void printLeafsError(){
        try {
            final int N = 20;
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder(1024);
            for (String line : lines) {
                sb.append(line);
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            String fromFile = sb.toString();

            LOGGER.log(Level.INFO, "Symbols that appear most in text: " + TextAction.printLeafs(fromFile, N));
        } catch(IOException e){
            LOGGER.log(Level.ERROR, e.getMessage());
        } catch(IndexOutOfBoundsException e){
            LOGGER.log(Level.ERROR, "Not able to find N unique symbols in text\n");
        }
    }
}