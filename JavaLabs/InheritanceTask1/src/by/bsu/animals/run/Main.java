package by.bsu.animals.run;

import by.bsu.animals.animalsHandler.Handler;
import by.bsu.animals.entity.Animal;
import by.bsu.animals.entity.Dog;
import by.bsu.animals.entity.Puppy;
import by.bsu.animals.exception.AnimalAgeException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args){
        try {
            Animal dog = new Dog("Jack", 20);
            Puppy puppy = new Puppy("Pooh", 3,16);
            Handler.animalVisualizer(puppy);

        } catch(AnimalAgeException e){
            logger.log(Level.ERROR, "Exception: " + e.getMessage());
            e.printStackTrace();
            //logger outputs info on the console as well as in files
        }
    }
}
