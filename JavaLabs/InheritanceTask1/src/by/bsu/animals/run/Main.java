package by.bsu.animals.run;

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
            Animal dog = new Dog("Jack", 29);
            Dog puppy = new Puppy("Pooh", 3);
            logger.log(Level.INFO, "Puppy's characteristics: \n" + puppy.toString()+"\n");
            logger.log(Level.INFO, "What puppy has done in this session:\n"
            + puppy.makeVoice() + "\n" + puppy.jump()+ "\n" + puppy.run() + "\n" + puppy.bite());

        } catch(AnimalAgeException e){
            logger.log(Level.ERROR, "Exception: " + e.getMessage());
            //logger output info on the console as well as in files
        }
    }
}
