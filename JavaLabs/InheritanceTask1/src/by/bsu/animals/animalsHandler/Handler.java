package by.bsu.animals.animalsHandler;

import by.bsu.animals.entity.Dog;
import by.bsu.animals.entity.Puppy;
import by.bsu.animals.run.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class contains methods for visualizing animal's characteristics and behaviour
 * throughout the app. Methods are called from Main
 */
public class Handler {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void animalVisualizer(Puppy puppy){
        logger.log(Level.INFO, "Puppy's characteristics: \n" + puppy.toString()+"\n");
        logger.log(Level.INFO, "What puppy has done in this session:\n"
                + puppy.makeVoice() + "\n" + puppy.jump()+ "\n" + puppy.run() + "\n" + puppy.bite());
    }

    public static void animalVisualizer(Dog dog){
        logger.log(Level.INFO, "Dog's characteristics: \n" + dog.toString()+"\n");
        logger.log(Level.INFO, "What dog has done in this session:\n"
                + dog.makeVoice() + "\n" + dog.jump()+ "\n" + dog.run() + "\n" + dog.bite());
    }
}
