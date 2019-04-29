package by.bsu.phonesUtilizer.fileReader;

import by.bsu.phonesUtilizer.entity.Phone;
import by.bsu.phonesUtilizer.exceptions.InvalidHardwareParametersException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneReaderTest {
    private static final Logger LOGGER = LogManager.getLogger(PhoneReaderTest.class.getName());
    private String filePath = "E:\\4sem_MMF\\JavaLabs\\InnerClass\\data\\phones.txt";

    /**This method tests possibility
     * of app to read strings from file and convert them to class Objects.
     */
    @Test
    void readerTest() {
        try{
            PhoneReader reader = new PhoneReader();
            List<Phone> actual = reader.readFromFile(filePath);
            List<Phone> expected = new ArrayList<>(){
                {
                    add(new Phone("samsung",399.9,2014,32,2,2000,7));
                    add(new Phone("apple",799.9,2012,32,2,1500,12));
                }
            };
            assertEquals(expected, actual);
            LOGGER.log(Level.DEBUG, "What we read from file: \n" + expected);
        } catch(NumberFormatException e){
            LOGGER.log(Level.ERROR, "Wrong type of data in file\n" + e);
        } catch(IllegalArgumentException e){
            LOGGER.log(Level.ERROR, "Couldn't able to find producer from file among our producersList\n" + e);
        } catch(InvalidHardwareParametersException e){
            LOGGER.log(Level.ERROR, e);
        } catch(IOException e){
            LOGGER.log(Level.ERROR, "Problems with FileReader: " + e);
        }
    }
}
