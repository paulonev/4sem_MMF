package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Car;
import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.entity.fewPassengersCar.EconomCar;
import by.bsu.taxipark.entity.minivan.Minivan;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**This class sorts cars according to their fuel_consumption values
 * with the help of Comparator<Car> and Collections.sort implemented on Comparator's method compare
 * And checks expected and actual lists
 * @see by.bsu.taxipark.tasks.CarConsumptionComparator
 */
class FuelConsumptionSortingTest {
    String filePath = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data.txt";
    private static final Logger logger = LogManager.getLogger(CarPriceCalculatorTest.class.getName());

    @Test
    void sortingTest() {
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath);
            logger.log(Level.INFO, "Test list was successfully created");
            List<Car> expected = new ArrayList<>() {
                {
                    add(new EconomCar("VOLKSWAGEN_POLO",2010,5.5,9599.9,120,30,true));
                    add(new ComfortCar("TOYOTA_CAMRY",2015,7.3,14999.9,160,20,true,true));
                    add(new BusinessCar("MERCEDES-BENZ_E-KLASSE",2016,8.4,19000.0,180,30,true,true,true));
                    add(new Minivan("VOLKSWAGEN_CADDY",2014,10.2,25000.0,120,12));
                }
            };

            List<Car> actual = park.getCarPool();
            Collections.sort(actual, new CarConsumptionComparator());

            assertEquals(expected, actual);
            logger.log(Level.DEBUG, "Our sorted list" + actual);
        } catch (WrongDataException e) {
            logger.log(Level.ERROR, "Exception " + e.getMessage());
        } catch(FileNotFoundException e){
            logger.log(Level.ERROR,e.getMessage());
        }
    }
}