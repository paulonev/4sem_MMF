package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Car;
import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.taxipark.tasks.SpeedLimitsCarsSelector.getAutoBySpeedLimit;
import static org.junit.jupiter.api.Assertions.*;

/**Этот класс реализует метод отбора автомобилей парка по диапазону скорости
 * @see by.bsu.taxipark.tasks.SpeedLimitsCarsSelector
 */
class SpeedLimitsCarsSelectorTest {
    String filePath = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data.txt";
    private static final Logger logger = LogManager.getLogger(CarPriceCalculatorTest.class.getName());

    @Test
    void speedSelectionTest() {
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath);
            logger.log(Level.INFO,"Test list was successfully created");
            List<Car> expected = new ArrayList<>() {
                {
                    add(new ComfortCar("TOYOTA_CAMRY",2015,7.3,14999.9,160,20,true,true));
                    add(new BusinessCar("MERCEDES-BENZ_E-KLASSE",2016,8.4,19000.0,180,30,true,true,true));
                }
            };

            List<Car> actual = getAutoBySpeedLimit(130, 190,park.getCarPool());
            assertEquals(expected, actual);
        }catch(WrongDataException e){
            logger.log(Level.ERROR,"Exception " + e.getMessage());
        }catch(FileNotFoundException e){
            logger.log(Level.ERROR, e);
        }
    }
}