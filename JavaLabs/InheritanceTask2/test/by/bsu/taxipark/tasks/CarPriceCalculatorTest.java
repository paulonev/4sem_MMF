package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static by.bsu.taxipark.tasks.CarPriceCalculator.getSumOfTaxiPark;
import static org.junit.jupiter.api.Assertions.*;

/**Этот класс реализует метод подсчёта стоимости автопарка.
 *
 */
class CarPriceCalculatorTest {
    String filePath = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data2.txt";
    private static final Logger logger = LogManager.getLogger(CarPriceCalculatorTest.class.getName());

    @Test
    void getSumOfTaxiParkTest() throws IOException, WrongDataException {
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath);
            logger.log(Level.INFO,"Test list was successfully created");
            double expected = 134000.0;
            double actual = getSumOfTaxiPark(park.getCarPool());
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(NumberFormatException e){
            logger.log(Level.ERROR, "Not valid data. " + e.getMessage() + "\nCheck resources file");
        }
    }
}