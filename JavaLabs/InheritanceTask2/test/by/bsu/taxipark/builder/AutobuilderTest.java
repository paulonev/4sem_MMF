package by.bsu.taxipark.builder;

import by.bsu.taxipark.entity.Auto;
import by.bsu.taxipark.entity.TaxiPark;
import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.entity.fewPassengersCar.EconomCar;
import by.bsu.taxipark.entity.minivan.Minivan;
import by.bsu.taxipark.exception.WrongDataException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import static org.junit.jupiter.api.Assertions.*;

/**This class tests some functions of my app
 * @author Paul Okunev
 * @version 1.0
 */
class AutobuilderTest {
    String filePath1 = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data.txt";
    String filePath2 = "E:\\4sem_MMF\\JavaLabs\\InheritanceTask2\\data\\data2.txt";
    private final Logger logger = LogManager.getLogger(AutobuilderTest.class.getName());

    @Test
    /**This method tests creating a list of cars from file
     * catches NumberFormatException if there were spaces in file like " 2012" or other symbols not allowed for parsing to a number
     * catches WrongDataException if automobile doesn't match any category(econom, comfort, business or minivan)
     */
    void createAutoParkTest(){
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath1);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Auto> expected = new ArrayList<>();
            expected.add(new ComfortCar("Toyota Camry", 2015, 7.3, 14999.9, 160));
            expected.add(new BusinessCar("Mercedes-Benz E-klasse",2016,8.4,19000.0,180));
            expected.add(new EconomCar("Volkswagen Polo", 2010, 5.5, 9599.9, 120));
            List<Auto> actual = park.getCarPool();
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(NumberFormatException e){
            logger.log(Level.ERROR, "Unable to parse string to number; " + e.getMessage());
        }
    }

    @Test
    /**This method tests creating a list of econom cars from file
     * catches NumberFormatException  if there were spaces in file like " 2012" or other symbols not allowed for parsing to a number
     * catches WrongDataException   if automobile doesn't match any category(econom, comfort, business or minivan)
     *
     */
    void createEconomAutoPark(){
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath2);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Auto> expected = new ArrayList<>() {
                {
                    add(new EconomCar("Volkswagen Polo", 2012, 5.5, 9599.9, 120));
                    add(new EconomCar("Skoda Rapid", 2013, 6.2, 10099.9, 120));
                }
            };
            List<Auto> actual = park.getEconomPool(park.getCarPool());
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(NumberFormatException e){
            logger.log(Level.ERROR, "Unable to parse string to number; " + e.getMessage());
        }
    }

    @Test
    /**This method tests creating a list of comfort cars from file
     * catches NumberFormatException   if there were spaces in file like " 2012" or other symbols not allowed for parsing to a number
     * catches WrongDataException   if automobile doesn't match any category(econom, comfort, business or minivan)
     * */
    void createComfortAutoPark() throws IOException, WrongDataException{
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath2);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Auto> expected = new ArrayList<>() {
                {
                    add(new ComfortCar("Toyota Camry",2015,7.6,15999.9,160));
                    add(new ComfortCar("Skoda Superb",2016,7.2,14399.9,140));
                }
            };
            List<Auto> actual = park.getComfortPool(park.getCarPool());
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(NumberFormatException e){
            logger.log(Level.ERROR, "Unable to parse string to number; " + e.getMessage());
        }
    }

    @Test
    /**This method tests creating a list of business cars from file
     * catches NumberFormatException  if there were spaces in file like " 2012" or other symbols not allowed for parsing to a number
     * catches WrongDataException   if automobile doesn't match any category(econom, comfort, business or minivan)
     *
     */
    void createBusinessAutoPark() throws IOException, WrongDataException{
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath2);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Auto> expected = new ArrayList<>() {
                {
                    add(new BusinessCar("Mercedes-Benz E-klasse",2016,8.4,18999.9,180));
                    add(new BusinessCar("Audi A6",2016,7.5,17999.9,180));
                }
            };
            List<Auto> actual = park.getBusinessPool(park.getCarPool());
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(NumberFormatException e){
            logger.log(Level.ERROR, "Unable to parse string to number; " + e.getMessage());
        }
    }

    @Test
    /**This method tests creating a list of minivans from file
     * catches NumberFormatException  if there were spaces in file like " 2012" or other symbols not allowed for parsing to a number
     * catches WrongDataException   if automobile doesn't match any category(econom, comfort, business or minivan)
     *
     */
    void createVanAutoPark(){
        try {
            TaxiPark park = new TaxiPark();
            park.setCarPool(filePath2);
            logger.log(Level.INFO, "Taxi park was successfully created");
            List<Auto> expected = new ArrayList<>() {
                {
                    add(new Minivan("Volkswagen Caddy",2014,10.2,24999.9,120));
                    add(new Minivan("Ford Galaxy",2014,11.1,21999.9,110));
                }
            };
            List<Auto> actual = park.getVanPool(park.getCarPool());
            assertEquals(expected, actual);
        } catch(WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        } catch(NumberFormatException e){
            logger.log(Level.ERROR, "Unable to parse string to number; " + e.getMessage());
        }
    }
}