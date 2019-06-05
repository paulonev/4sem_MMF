package by.bsu.taxipark.util;

import by.bsu.taxipark.entity.Car;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.entity.fewPassengersCar.EconomCar;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SerializatorTest {
    private static Logger LOGGER = LogManager.getLogger(Serializator.class.getName());
    private static String filePath = "data\\objects213.txt";

    @Test
    void serialization() {
        try {
            Car car1 = new EconomCar("VOLKSWAGEN_POLO", 2010, 5.5, 9599.9, 120, 30, true);
            Serializator szt = new Serializator();
            boolean serializationSuccess = szt.serialization(car1, filePath);
            assertTrue(serializationSuccess);
            LOGGER.log(Level.DEBUG, "Serialization successfully completed. You can check it in the file. ");
        } catch(NotSerializableException e){
            LOGGER.log(Level.ERROR, "Class is not serializable: "+ e);
        } catch(IOException e){
            LOGGER.log(Level.ERROR,e);
        }
    }

    @Test
    void deserialization() {
        try {
            Car car_new;
            Serializator szt1 = new Serializator();
            //car_new = szt1.deserialization("data\\objects.txt");
            car_new = szt1.deserialization(filePath);
            //Car.setType("MOTORCYCLE");
            Car expected = new EconomCar("VOLKSWAGEN_POLO", 2010, 5.5, 9599.9, 120, 30,true);
            assertEquals(expected, car_new);
            LOGGER.log(Level.DEBUG, "Deserialization successfully completed.");
        } catch (InvalidObjectException invOE){
            LOGGER.log(Level.ERROR, invOE.getMessage());
        }
    }
}