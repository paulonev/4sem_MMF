package by.bsu.taxipark.builder;

import by.bsu.taxipark.entity.Car;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.init.CarStorageInitializer;
import by.bsu.taxipark.storage.CarStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutOfMemoryTest {
    private static final Logger logger = LogManager.getLogger(OutOfMemoryTest.class);

    @Test
    public void init(){
        try {
            List<Car> cars = new ArrayList<>();
            while(true){
                cars.add(new ComfortCar("TOYOTA_CAMRY",2015,7.3,14999.9,160,20,true,true));

            }
        } catch (OutOfMemoryError e){
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
