package by.bsu.taxipark.builder;

import by.bsu.taxipark.entity.fewPassengersCar.BusinessCar;
import by.bsu.taxipark.entity.fewPassengersCar.ComfortCar;
import by.bsu.taxipark.entity.fewPassengersCar.EconomCar;
import by.bsu.taxipark.entity.minivan.Minivan;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.parse.CarpoolParser;

/**
 *  This class is responsible for building cars for carPool(list of cars)
 */
public class Carbuilder {
    private CarpoolParser parser;

    public Carbuilder(){}

    public Carbuilder(CarpoolParser parser) {
        this.parser = parser;
    }

    public void setParser(CarpoolParser parser) {
        this.parser = parser;
    }

    public Minivan createMinivan() throws WrongDataException, OutOfMemoryError{
        return new Minivan(parser.takeCarModel(),parser.takeCarYear(),parser.takeCarConsumption(),
                parser.takeCarPrice(),parser.takeCarSpeed(),parser.takeCarMaxPassengers());
    }

    public EconomCar createEconomCar() throws WrongDataException,OutOfMemoryError {
        return new EconomCar(parser.takeCarModel(),parser.takeCarYear(),parser.takeCarConsumption(),
                parser.takeCarPrice(),parser.takeCarSpeed(),parser.takeCarLuggageWeight(),parser.takeCarConditioning());
    }

    public ComfortCar createComfortCar() throws WrongDataException,OutOfMemoryError{
        return new ComfortCar(parser.takeCarModel(),parser.takeCarYear(),parser.takeCarConsumption(),parser.takeCarPrice(),
                parser.takeCarSpeed(),parser.takeCarLuggageWeight(),parser.takeCarConditioning(),parser.takeCarBeverages());
    }

    public BusinessCar createBusinessCar() throws WrongDataException ,OutOfMemoryError{
        return new BusinessCar(parser.takeCarModel(),parser.takeCarYear(),parser.takeCarConsumption(),parser.takeCarPrice(),
                parser.takeCarSpeed(),parser.takeCarLuggageWeight(),parser.takeCarConditioning(),parser.takeCarBeverages(),parser.takeCarBatteryCharger());
    }

}
