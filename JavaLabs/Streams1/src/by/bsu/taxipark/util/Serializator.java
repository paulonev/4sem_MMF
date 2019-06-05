package by.bsu.taxipark.util;

import by.bsu.taxipark.entity.Car;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Serializator {
    private static Logger LOGGER = LogManager.getLogger(Serializator.class.getName());

    /**Serialize objects to file.
     *
     * @param s         object to be serialized
     * @param fileName  file where to serialize
     * @return          true - if was serialized, false - if exception happened
     * @throws NotSerializableException     class doesn't implement Serializable
     * @throws IOException                  sort of general input/output exceptions
     */
    public boolean serialization(Car s, String fileName) throws NotSerializableException, IOException{
        boolean flag = false;
        ObjectOutputStream objOutStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            if (fos != null) {
                objOutStream = new ObjectOutputStream(fos);
                objOutStream.writeObject(s); // сериализация
                flag = true;
            }
        } catch (NotSerializableException e) {
            throw new NotSerializableException();
        } catch (IOException e) {
            throw new IOException("General I/O exception");
        } finally {
            try {
                if (objOutStream != null) objOutStream.close();
            } catch (IOException e) { //didn't do throw in finally because of system warning!
                LOGGER.log(Level.ERROR,"Exception while closing stream.");
            }
        }
        return flag;
    }


    /**Convert serialized string in file into object
     *
     * @param fileName  file where serialized string lies
     * @return          Car object - if not exception
     * @throws InvalidObjectException   cause of other exceptions, string wasn't deserialized into object
     */
    public Car deserialization(String fileName) throws InvalidObjectException {
        ObjectInputStream istream = null;
        try {
            istream = new ObjectInputStream(new FileInputStream(new File(fileName)));
            return (Car) istream.readObject(); // десериализация

        } catch (ClassNotFoundException ce) {
            LOGGER.log(Level.ERROR,"Class doesn't exist: " + ce);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.ERROR,"Not able to find file: "+ e);
        } catch (InvalidClassException ioe) {
            LOGGER.log(Level.ERROR,"Class versions incompatibility: " + ioe);
        } catch (IOException ioe) {
            LOGGER.log(Level.ERROR,"General I/O exception: " + ioe);
        } finally {
            try {
                if (istream != null) istream.close();
            } catch (IOException e) {
                LOGGER.log(Level.ERROR,"Exception while closing stream.");
            }
        }
        throw new InvalidObjectException("Object wasn't deserialized");
    }
}

