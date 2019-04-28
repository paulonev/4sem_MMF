package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Auto;
import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.taxipark.tasks.SpeedLimitsCarsSelector.getAutoBySpeedLimit;
import static org.junit.jupiter.api.Assertions.*;

/**Этот класс реализует метод отбора автомобилей парка по диапазону скорости
 * Тестируемый метод находится в классе TaxiPark, так как напрямую работаем с парком
 * @see by.bsu.taxipark.entity.TaxiPark
 */
class SpeedLimitsCarsSelectorTest {
    String filePath = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data2.txt";
    private static final Logger logger = LogManager.getLogger(CarPriceCalculatorTest.class.getName());

    @Test
    void speedSelectionTest() {
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath);
            logger.log(Level.INFO,"Test list was successfully created");
            List<Auto> expected = new ArrayList<>() {
                {
                    add(new ComfortCar("Toyota Camry", 2015, 7.6, 16000.0, 160));
                    add(new ComfortCar("Skoda Superb", 2016, 7.2, 14400.0, 140));
                    add(new BusinessCar("Mercedes-Benz E-klasse", 2016, 8.4, 19000.0, 180));
                    add(new BusinessCar("Audi A6", 2016, 7.5, 18000.0, 180));
                }
            };

            List<Auto> actual = getAutoBySpeedLimit(130, 190,park.getCarPool());
            assertEquals(expected, actual);
        }catch(WrongDataException e){
            logger.log(Level.ERROR,"Exception " + e.getMessage());
        }catch(NumberFormatException e){
            logger.log(Level.ERROR, "Not valid data. " + e.getMessage() + "\nCheck resources file");
        }
    }
}