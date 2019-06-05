package by.bsu.taxipark.init;

import by.bsu.taxipark.builder.Carbuilder;
import by.bsu.taxipark.entity.CarClassification;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.parse.CarpoolParser;
import by.bsu.taxipark.storage.CarStorage;
import org.apache.logging.log4j.Level;

import java.util.LinkedList;

public class CarStorageInitializer {
    /**
     * This method initializes carStorage that stores strings of data from list
     * @param strings   list of data from which to fill storage
     * @return          car storage
     * @throws WrongDataException   if string doesn't represent car
     * @throws OutOfMemoryError     if jvm wasn't able to allocate memory
     */
    public CarStorage init(LinkedList<String> strings) throws WrongDataException, OutOfMemoryError {
        CarStorage storage = CarStorage.getInstance(); //singleton
        CarClassification carClassification;

        CarpoolParser carpoolParser;
        Carbuilder carbuilder;
        while(!strings.isEmpty()){
            carpoolParser = new CarpoolParser(strings.removeFirst()); //init parser
            carbuilder = new Carbuilder(carpoolParser); //init builder

                carClassification = carpoolParser.takeCarClass();
                switch (carClassification){
                    case ECONOM: {
                        storage.addCar(carbuilder.createEconomCar());
                        break;
                    }
                    case COMFORT: {
                        storage.addCar(carbuilder.createComfortCar());
                        break;
                    }
                    case BUSINESS: {
                        storage.addCar(carbuilder.createBusinessCar());
                        break;
                    }
                    case VAN: {
                        storage.addCar(carbuilder.createMinivan());
                        break;
                    }
                    default:
                        throw new WrongDataException("Not valid car class!");
                }
        }
        return storage;
    }
}
