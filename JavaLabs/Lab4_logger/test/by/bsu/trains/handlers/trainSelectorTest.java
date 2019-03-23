package by.bsu.trains.handlers;

import by.bsu.trains.Factory.TrainsFactory;
import by.bsu.trains.entity.Train;
import by.bsu.trains.exceptions.NotValidAmountOfSeatsException;
import by.bsu.trains.handlers.trainSelector.*;
import by.bsu.trains.strategy.*;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

import static by.bsu.trains.handlers.trainSelector.*;
import static org.junit.jupiter.api.Assertions.*;

class trainSelectorTest{
    private TrainsFactory tf = new TrainsFactory();
    private final Logger logger = LogManager.getLogger(trainSelectorTest.class.getName());

    /**This tests method for selecting trains from a list
     * that travel to a certain point.
     * If test fails exception will be logged into file
     */
    @Test
    void SelectTrainByDestPoint() throws DateTimeException,
            NotValidAmountOfSeatsException,org.opentest4j.AssertionFailedError
    {
        try {
            logger.log(Level.INFO,"Initialize test method \"SelectTrainByDestPoint\"");

            ArrayList<Train> trains = new ArrayList<>(){
                {
                    add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
                    add(tf.trainFactory(192890, "Brest", 7, 1, 1, 0, 19, 30));
                    add(tf.trainFactory(384759, "Grodno", 3, 1, 2, 0, 20, 40));
                    add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
                    add(tf.trainFactory(102984, "Minsk", 1, 1, 4, 0, 13, 50));
                    add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
                }
            };
            logger.log(Level.INFO,"List of trains was successfully created.");
            ArrayList<Train> expected = new ArrayList<>();
            expected.add(tf.trainFactory(203948, "Brest", 8, 1, 3, 7, 9, 15));
            assertEquals(expected,getTrainsWithDestPoint(trains,"Mogilev"));
            logger.log(Level.INFO,"Test method finished properly");

        }
        catch (org.opentest4j.AssertionFailedError e){
            logger.log(Level.ERROR,"Test failed\n" + e.getMessage());
        }
        catch (DateTimeException e){
            //заносить в лог информацию об исключении
            logger.log(Level.ERROR,"Exception:\n" + e.getMessage());
        }
        catch(NotValidAmountOfSeatsException e){
            logger.log(Level.ERROR,"Exception while creating trains list:\n" + e.getMessage());
        }
    }

    /**This tests method for selecting trains from a list
     * that travel to a certain point and depart after a certain time
     * If test fails exception will be logged into file
     */
    @Test
    void SelectTrainByDestPointAndDepTime() throws DateTimeException,
            NotValidAmountOfSeatsException,org.opentest4j.AssertionFailedError
    {
        try {
            logger.log(Level.INFO,"Initialize test method \"SelectTrainByDestPointAndDepTime\"");

            ArrayList<Train> trains = new ArrayList<>(){
                {
                    add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
                    add(tf.trainFactory(192890, "Brest", 7, 1, 1, 0, 19, 30));
                    add(tf.trainFactory(384759, "Grodno", 3, 1, 2, 0, 20, 40));
                    add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
                    add(tf.trainFactory(102984, "Minsk", 1, 1, 4, 0, 13, 50));
                    add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
                }
            };
            logger.log(Level.INFO,"List of trains was successfully created.");
            LocalTime depTime = LocalTime.of(14,0);
            ArrayList<Train> expected = new ArrayList<>();
            expected.add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
            assertEquals(expected,getTrainsWithDestPointAndDepTime(trains,"Minsk",depTime));
            logger.log(Level.INFO,"Test method finished properly");
        }
        catch (org.opentest4j.AssertionFailedError e){
            logger.log(Level.ERROR,"Test failed\n" + e.getMessage());
        }
        catch (DateTimeException e){
            //заносить в лог информацию об исключении
            logger.log(Level.ERROR,"Exception:\n" + e.getMessage());
        }
        catch(NotValidAmountOfSeatsException e){
            logger.log(Level.ERROR,"Exception while creating trains list:\n" + e.getMessage());
        }
    }

    /**This tests method for selecting trains from a list
     * that travel to a certain point and have at least 1 seat of common
     * If test fails exception will be logged into file
     */
    @Test
    void SelectTrainByDestPointAndCommonSeats() throws DateTimeException,
            NotValidAmountOfSeatsException,org.opentest4j.AssertionFailedError
    {
        try {
            logger.log(Level.INFO,"Initialize test method \"SelectTrainByDestPointAndCommonSeats\"");

            ArrayList<Train> trains = new ArrayList<>(){
                {
                    add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
                    add(tf.trainFactory(192890, "Brest", 0, 1, 1, 0, 19, 30));
                    add(tf.trainFactory(384759, "Grodno", 3, 1, 2, 0, 20, 40));
                    add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
                    add(tf.trainFactory(102984, "Minsk", 1, 1, 4, 0, 13, 50));
                    add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
                }
            };
            logger.log(Level.INFO,"List of trains was successfully created.");

            ArrayList<Train> expected = new ArrayList<>();
            expected.add(tf.trainFactory(192890, "Brest", 7, 1, 1, 0, 19, 30));
            expected.add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
            assertEquals(expected,getTrainsWithDestPointAndSeats(trains,"Brest"));
            logger.log(Level.INFO,"Test method finished properly");
        }
        catch (org.opentest4j.AssertionFailedError e){
            logger.log(Level.ERROR,"Test failed\n" + e.getMessage());
        }
        catch (DateTimeException e){
            //заносить в лог информацию об исключении
            logger.log(Level.ERROR,"Exception:\n" + e.getMessage());
        }
        catch(NotValidAmountOfSeatsException e){
            logger.log(Level.ERROR,"Exception while creating trains list:\n" + e.getMessage());
        }
    }

    /**This tests method for selecting trains from a list
     * that have maximum amount of certain type of seats.
     * Type is set using Strategy pattern.
     * If test fails exception will be logged into a file.
     */
    @Test
    void selectTrainsByMaxAmountOfTypesOfSeats() throws DateTimeException,
            NotValidAmountOfSeatsException,org.opentest4j.AssertionFailedError
    {
        try {
            Context context = new Context();
            String variant = "lux";
            switch (variant) {
                case "lux": {
                    context.setStrategy(new ConcreteStrategyLuxSeats());
                    break;
                }
                case "platscart": {
                    context.setStrategy(new ConcreteStrategyPlSeats());
                    break;
                }
                case "common": {
                    context.setStrategy(new ConcreteStrategyCommonSeats());
                    break;
                }
                case "coupe": {
                    context.setStrategy(new ConcreteStrategyCoupeSeats());
                    break;
                }
            }
            logger.log(Level.INFO,"Initialize test method \"selectTrainsByMaxAmountOfTypesOfSeats\"");

            ArrayList<Train> trains = new ArrayList<>(){
                {
                    add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
                    add(tf.trainFactory(192890, "Brest", 7, 1, 1, 0, 19, 30));
                    add(tf.trainFactory(384759, "Grodno", 3, 1, 2, 0, 20, 40));
                    add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
                    add(tf.trainFactory(102984, "Minsk", 1, 1, 4, 0, 13, 50));
                    add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
                }
            };
            logger.log(Level.INFO,"List of trains was successfully created.");
            ArrayList<Train> expected = new ArrayList<>();
            expected.add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
            assertEquals(expected,context.trainsSelectionStrategy(trains));
            logger.log(Level.INFO,"Test method finished properly");

        }
        catch (org.opentest4j.AssertionFailedError e){
            logger.log(Level.ERROR,"Test failed\n" + e.getMessage());
        }
        catch (DateTimeException e){
            //заносить в лог информацию об исключении
            logger.log(Level.ERROR,"Exception:\n" + e.getMessage());
        }
        catch(NotValidAmountOfSeatsException e){
            logger.log(Level.ERROR,"Exception while creating trains list:\n" + e.getMessage());
        }
    }

    /**This tests method for seats of certain type.
     * Type is set using Strategy pattern.
     * If test fails exception will be logged into a file.
     */
    @Test
    void countSeatsOfAnyType() throws DateTimeException,
            NotValidAmountOfSeatsException,org.opentest4j.AssertionFailedError
    {
        try {
            Context context = new Context();
            String variant = "lux";
            switch (variant) {
                case "lux": {
                    context.setStrategy(new ConcreteStrategyLuxSeats());
                    break;
                }
                case "platscart": {
                    context.setStrategy(new ConcreteStrategyPlSeats());
                    break;
                }
                case "common": {
                    context.setStrategy(new ConcreteStrategyCommonSeats());
                    break;
                }
                case "coupe": {
                    context.setStrategy(new ConcreteStrategyCoupeSeats());
                    break;
                }
            }
            logger.log(Level.INFO,"Initialize test method \"countSeatsOfAnyType\"");

            ArrayList<Train> trains = new ArrayList<>(){
                {
                    add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
                    add(tf.trainFactory(192890, "Brest", 7, 1, 1, 0, 19, 30));
                    add(tf.trainFactory(384759, "Grodno", 3, 1, 2, 0, 20, 40));
                    add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
                    add(tf.trainFactory(102984, "Minsk", 1, 1, 4, 0, 13, 50));
                    add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
                }
            };
            logger.log(Level.INFO,"List of trains was successfully created.");
            assertEquals(16,context.seatsCounterStrategy(trains));
            logger.log(Level.INFO,"Test method finished properly");

        }
        catch (org.opentest4j.AssertionFailedError e){
            logger.log(Level.ERROR,"Test failed\n" + e.getMessage());
        }
        catch (DateTimeException e){
            //заносить в лог информацию об исключении
            logger.log(Level.ERROR,"Exception:\n" + e.getMessage());
        }
        catch(NotValidAmountOfSeatsException e){
            logger.log(Level.ERROR,"Exception while creating trains list:\n" + e.getMessage());
        }
    }

    /**This tests method for selecting trains from a list
     * that have the earliest departure time.
     * If test fails exception will be logged into a file.
     */
    @Test
    void selectEarliestTrain() throws DateTimeException,
            NotValidAmountOfSeatsException,org.opentest4j.AssertionFailedError
    {
        try {
            logger.log(Level.INFO,"Initialize test method \"selectEarliestTrain\"");

            ArrayList<Train> trains = new ArrayList<>(){
                {
                    add(tf.trainFactory(192887, "Minsk", 5, 4, 8, 9, 18, 10));
                    add(tf.trainFactory(192890, "Brest", 7, 1, 1, 0, 19, 30));
                    add(tf.trainFactory(384759, "Grodno", 3, 1, 2, 0, 20, 40));
                    add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
                    add(tf.trainFactory(102984, "Minsk", 1, 1, 4, 0, 13, 50));
                    add(tf.trainFactory(298437, "Brest", 10, 1, 1, 0, 19, 20));
                }
            };
            logger.log(Level.INFO,"List of trains was successfully created.");
            ArrayList<Train> expected = new ArrayList<>();
            expected.add(tf.trainFactory(203948, "Mogilev", 8, 1, 3, 7, 9, 15));
            assertEquals(expected,getEarliestTrain(trains));
            logger.log(Level.INFO,"Test method finished properly");

        }
        catch (org.opentest4j.AssertionFailedError e){
            logger.log(Level.ERROR,"Test failed\n" + e.getMessage());
        }
        catch (DateTimeException e){
            //заносить в лог информацию об исключении
            logger.log(Level.ERROR,"Exception:\n" + e.getMessage());
        }
        catch(NotValidAmountOfSeatsException e){
            logger.log(Level.ERROR,"Exception while creating trains list:\n" + e.getMessage());
        }
    }
}