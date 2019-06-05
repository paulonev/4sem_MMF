package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static by.bsu.taxipark.tasks.CarPriceCalculator.getSumOfTaxiPark;
import static org.junit.jupiter.api.Assertions.*;

/**Этот класс реализует метод подсчёта стоимости автопарка.
 *
 */
class CarPriceCalculatorTest {
    String filePath = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data.txt";
    private static final Logger logger = LogManager.getLogger(CarPriceCalculatorTest.class.getName());

    @Test
    void getSumOfTaxiParkTest() {
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath);
            logger.log(Level.INFO,"Test list was successfully created");
            double expected = 68599.8;
            double actual = getSumOfTaxiPark(park.getCarPool());
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(FileNotFoundException e){
            logger.log(Level.ERROR, e);
        }
    }
}