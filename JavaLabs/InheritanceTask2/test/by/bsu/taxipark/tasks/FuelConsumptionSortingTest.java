package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Auto;
import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.entity.fewPassengersCar.EconomCar;
import by.bsu.taxipark.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**Этот класс производит сортировку автомобилей по объему потребления топлива
 * с помощью Comparator<Auto> и Collections.sort по компаратору
 * И сразу же проверяет expected и actual списки
 */
class FuelConsumptionSortingTest {
    String filePath = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data.txt";
    private static final Logger logger = LogManager.getLogger(CarPriceCalculatorTest.class.getName());

    @Test
    void sortingTest(){
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath);
            logger.log(Level.INFO,"Test list was successfully created");
            List<Auto> expected = new ArrayList<>() {
                {
                    add(new EconomCar("Volkswagen Polo", 2010, 5.5, 9599.9, 120));
                    add(new ComfortCar("Toyota Camry", 2015, 7.3, 14999.9, 160));
                    add(new BusinessCar("Mercedes-Benz E-klasse", 2016, 8.4, 19000.0, 180));
                }
            };
            Comparator<Auto> compareByFuelConsumption =
                    (Auto o1, Auto o2) -> (int) (o1.getFuelConsumption() - o2.getFuelConsumption());

            List<Auto> actual = park.getCarPool();
            Collections.sort(actual, compareByFuelConsumption);

            assertEquals(expected, actual);
            logger.log(Level.DEBUG, "Our sorted list" + actual);
        }catch(WrongDataException e){
            logger.log(Level.ERROR,"Exception " + e.getMessage());
        }catch(NumberFormatException e){
            logger.log(Level.ERROR, "Not valid data. " + e.getMessage() + "\nCheck resources file");
        }
    }

}