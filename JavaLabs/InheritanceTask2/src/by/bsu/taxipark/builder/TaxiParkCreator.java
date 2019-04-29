package by.bsu.taxipark.builder;

import by.bsu.taxipark.entity.Car;
import by.bsu.taxipark.entity.CarClassification;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.parse.CarpoolParser;
import by.bsu.taxipark.read.fileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TaxiParkCreator {

    /**Method with the key logic of app. It creates a builder that builds inherited objects.
     * It accepts string representation of file.
     * It establishes a parser that converts string data from file into parameters of objects.
     *
     * @param filePath               location of data
     * @return                       ready to use taxi park
     * @throws WrongDataException    is thrown when there is a mistake in data file
     * @throws FileNotFoundException is thrown when unable to find and read from file
     */
    public List<Car> initializeTaxiPark(String filePath) throws WrongDataException, FileNotFoundException {
        Carbuilder builder = new Carbuilder();
        List<Car> carPool = new ArrayList<>();
        ArrayList<String> stringsFromFile = fileReader.readFile(filePath);
        for(String str : stringsFromFile){
            CarpoolParser parser = new CarpoolParser(str);
            builder.setParser(parser);
            switch (parser.takeCarClass()){
                case ECONOM:{
                    carPool.add(builder.createEconomCar());
                    break;
                }
                case COMFORT:{
                    carPool.add(builder.createComfortCar());
                    break;
                }
                case BUSINESS:{
                    carPool.add(builder.createBusinessCar());
                    break;
                }
                case VAN:{
                    carPool.add(builder.createMinivan());
                    break;
                }
                default:{
                    break;
                }
            }
        }
        return carPool;
    }

    /**Extra method for creating list of cars of ECONOM classification.
     * It creates a builder that builds inherited objects.
     * It accepts string representation of file.
     * It establishes a parser that converts string data from file into parameters of objects.
     *
     * @param filePath               location of data
     * @return                       ready to use taxi park
     * @throws WrongDataException    is thrown when there is a mistake in data file
     * @throws FileNotFoundException is thrown when unable to find and read from file
     */
    public List<Car> initializeEconomTaxiPark(String filePath) throws WrongDataException, FileNotFoundException {
        Carbuilder builder = new Carbuilder();
        List<Car> carPool = new ArrayList<>();
        ArrayList<String> stringsFromFile = fileReader.readFile(filePath);
        for(String str : stringsFromFile){
            CarpoolParser parser = new CarpoolParser(str);
            builder.setParser(parser);
            if(parser.takeCarClass() == CarClassification.ECONOM) carPool.add(builder.createEconomCar());
        }
        return carPool;
    }
}
