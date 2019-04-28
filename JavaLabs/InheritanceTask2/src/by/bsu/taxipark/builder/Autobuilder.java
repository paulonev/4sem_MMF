package by.bsu.taxipark.builder;

import by.bsu.taxipark.entity.Auto;
import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.entity.fewPassengersCar.EconomCar;
import by.bsu.taxipark.entity.minivan.Minivan;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.read.fileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

import static by.bsu.taxipark.constants.TaxiParkConstants.*;

public class Autobuilder implements IHashCreateable{
    /**
     * This method create list of cars from list of strings that were read from file
     *
     * @param stringsFromFile list of strings from file
     * @return list of cars(taxi park)
     * @throws WrongDataException if automobile doesn't match any category(econom, comfort, business or minivan)
     */
    public List<Auto> createTaxiPark(ArrayList<String> stringsFromFile) throws WrongDataException,NumberFormatException {
        List<Auto> cars = new ArrayList<>();
        //take string of arguments
        String argumentList = stringsFromFile.get(0);
        //для создания HashMap для моих параметров из первой строки файла с данными, если файл не пуст
        Map<String, Integer> carKeyMap = IHashCreateable.createHashMap(argumentList);

        //чтобы хранить именно данные, а не первую строку, где имена аргументов
        List<String> dataList = stringsFromFile.subList(1, stringsFromFile.size());
        for (String string : dataList) {
            String[] carValues = string.split(",");
            //collect values from string carValues
            String carModel = carValues[carKeyMap.get("model")];
            int carYear = Integer.parseInt(carValues[carKeyMap.get("year")]);
            double carFuelConsumption = Double.parseDouble(carValues[carKeyMap.get("consumption")]);
            double carPrice = Double.parseDouble(carValues[carKeyMap.get("price")]);
            int carMaxPassengers = Integer.parseInt(carValues[carKeyMap.get("maxPassengers")]);
            int carMaxSpeed = Integer.parseInt(carValues[carKeyMap.get("maxSpeed")]);
            boolean carConditioning = Boolean.parseBoolean(carValues[carKeyMap.get("airConditioning")]);
            boolean carBeverages = Boolean.parseBoolean(carValues[carKeyMap.get("beverages")]);

            if (carMaxPassengers == 4) {
                if (!carConditioning && !carBeverages && carYear >= MIN_RELEASED_YEAR) {
                    cars.add(new EconomCar(carModel, carYear, carFuelConsumption, carPrice, carMaxSpeed));
                } else if (carConditioning && !carBeverages && carYear >= MIN_RELEASED_YEAR_COMFORT) {
                    cars.add(new ComfortCar(carModel, carYear, carFuelConsumption, carPrice, carMaxSpeed));
                } else {
                    throw new WrongDataException("Mistake in the file. Car with such parameters doesn't match any category");
                }
            } else if (carMaxPassengers == 2 && carConditioning && carBeverages && carYear >= MIN_RELEASED_YEAR_BUSINESS) {
                cars.add(new BusinessCar(carModel, carYear, carFuelConsumption, carPrice, carMaxSpeed));
            } else if ((carMaxPassengers > 4 && carMaxPassengers < 15) && carConditioning && !carBeverages && carYear >= MIN_RELEASED_YEAR) {
                cars.add(new Minivan(carModel, carYear, carFuelConsumption, carPrice, carMaxSpeed));
            } else
                throw new WrongDataException("Mistake in the file. Car with such parameters doesn't match any category");

        }
        return cars;
    }
}
