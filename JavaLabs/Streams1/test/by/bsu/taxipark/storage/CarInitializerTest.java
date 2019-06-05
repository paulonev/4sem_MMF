package by.bsu.taxipark.storage;

import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.init.CarStorageInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;


class CarStorageInitializerTest {
    private static final Logger logger = LogManager.getLogger(CarStorageInitializerTest.class);

    @Test
    public void init(){
        try {
            LinkedList<String> strings = new LinkedList<>();
            strings.add("cl=oeir model=Volkswagen_Polo year=2010 consumption=5,5 price=9599,9 maxSpeed=120 luggageweight=30 airConditioning=true");
            strings.add("cl=van model=Volkswagen_Caddy year=2014 consumption=10,2 price=25000,0 maxPassengers=12 maxSpeed=130");
            CarStorageInitializer initializer = new CarStorageInitializer();
            CarStorage storage = initializer.init(strings);

            int expected = 1;
            int actual = storage.countOfCars();
            assertEquals(expected, actual);
        } catch (WrongDataException e){
            logger.log(Level.ERROR, e.getMessage());
        }
    }

}