package by.bsu.taxipark.builder;

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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**This class tests methods for creating taxi park
 * using method setCarPool
 * @see by.bsu.taxipark.entity.TaxiPark
 *
 */
class CarbuilderTest {
    private String filePath1 = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data.txt";
    private final Logger logger = LogManager.getLogger(CarbuilderTest.class);

    @Test
    void createTaxiParkTest(){
        try{
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath1);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Car> expected = new ArrayList<>();
            expected.add(new ComfortCar("TOYOTA_CAMRY",2015,7.3,14999.9,160,20,true,true));
            expected.add(new BusinessCar("MERCEDES-BENZ_E-KLASSE",2016,8.4,19000.0,180,30,true,true,true));
            expected.add(new EconomCar("VOLKSWAGEN_POLO",2010,5.5,9599.9,120,30,true));
            expected.add(new Minivan("VOLKSWAGEN_CADDY",2014,10.2,25000.0,120,12));
            List<Car> actual = park.getCarPool();
            assertEquals(expected, actual);
            //System.out.println(actual.toString());
        } catch(WrongDataException e){
            logger.log(Level.ERROR,e);
        } catch (FileNotFoundException e){
            logger.log(Level.ERROR,e.getMessage());
        }
    }

    @Test
    /**This method tests creating a list of econom cars from file
     * @see by.bsu.taxipark.entity.TaxiPark
     * @see by.bsu.taxipark.builder.TaxiParkCreator
     */
    void createEconomTaxiPark(){
        try{
            TaxiPark park = new TaxiPark();
            park.setEconomCarPool(filePath1);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Car> expected = new ArrayList<>();
            expected.add(new EconomCar("VOLKSWAGEN_POLO",2010,5.5,9599.9,120,30,true));
            List<Car> actual = park.getCarPool();
            assertEquals(expected, actual);
            //System.out.println(actual.toString());
        } catch(WrongDataException e){
            logger.log(Level.ERROR,e);
        } catch (FileNotFoundException e){
            logger.log(Level.ERROR,e.getMessage());
        }
    }
}