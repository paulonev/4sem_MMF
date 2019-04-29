package by.bsu.taxipark.validator;

import by.bsu.taxipark.constants.TaxiParkConstants;
import by.bsu.taxipark.entity.CarClassification;
import by.bsu.taxipark.util.FileTags;

import java.io.File;

/**Checks whether the parsed string represents a car
 *
 */
public class CarValidator {

    /**This method checks whether a string could represent a car
     * If string contains CL, MODEL, YEAR, PRICE, CONSUMPTION, MAXSPEED и AIRCONDITIONING,
     * then it represents an object of CAR class
     * @param car string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringACar(String car){
        return car.contains(FileTags.CL) && car.contains(FileTags.MODEL) && car.contains(FileTags.YEAR) && car.contains(FileTags.PRICE)
                && car.contains(FileTags.CONSUMPTION) && car.contains(FileTags.MAX_SPEED);
    }

    /**A string represents a fewPassengersCar if it's a car
     * and has field - luggage_weight
     *
     * @param car string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringAFewPassengersCar(String car){
        car = car.toUpperCase();
        return isStringACar(car) && car.contains(FileTags.LUGGAGE_WEIGHT);
    }

    /**A string represents a minivan if it's a car
     * and has field - maxPassengers
     *
     * @param car string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringAMinivan(String car){
        car = car.toUpperCase();
        return isStringACar(car) && car.contains(FileTags.MAX_PASSENGERS);
    }

    /**A string represents an econom car if it's a car
     * and has field - airConditioning set to true
     *
     * @param car string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringAnEconomCar(String car){
        car = car.toUpperCase();
        return isStringAFewPassengersCar(car) && car.contains(FileTags.AIR_CONDITIONING);
    }

    /**A string represents a comfort car if it's an econom car
     * and has field - beverages
     *
     * @param car string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringAComfortCar(String car){
        car = car.toUpperCase();
        return isStringAnEconomCar(car) && car.contains(FileTags.BEVERAGES);
    }

    /**A string represents a business car if it's a comfort car
     * and has field - batteryCharger
     *
     * @param car string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringABusinessCar(String car){
        car = car.toUpperCase();
        return isStringAComfortCar(car) && car.contains(FileTags.BATTERY_CHARGER);
    }

    /**Checks whether car class from file exists
     *
     * @param carClass class parameter from file
     * @return true - if exists, false - otherwise
     */
    public static boolean isValidCarClass(String carClass){
        CarClassification[] carClassesEnum = CarClassification.values();//list of enum-parameters

        for(CarClassification carClassEnum : carClassesEnum){
            if(carClassEnum.toString().equalsIgnoreCase(carClass)){
                return true;
            }
        }
        return false;
    }

    /**
     * This block checks validity of parameters taken from file. For example, in the file YEAR parameter
     * should be between 2008 and 2019
     */
    public static boolean isValidCarYear(int carYear){
        return carYear >= TaxiParkConstants.MIN_RELEASED_YEAR && carYear <= 2019;
    }
    public static boolean isValidConsumption(double carConsumption){
        return carConsumption >= TaxiParkConstants.MIN_FUEL_CONSUMPTION;
    }
    public static boolean isValidPrice(double carPrice){
        return carPrice >= TaxiParkConstants.MIN_CAR_PRICE;
    }
    public static boolean isValidMaxSpeed(int carMaxSpeed){
        return carMaxSpeed >= TaxiParkConstants.LOWEST_MAXSPEED;
    }
    public static boolean isValidLuggage_Weight(int carLuggage){
        return carLuggage >= TaxiParkConstants.MIN_LUGWEIGHT && carLuggage <= TaxiParkConstants.MAX_LUGWEIGHT;
    }
    public static boolean isValidMaxPassengers(int minivanPassengers){
        return minivanPassengers <= TaxiParkConstants.MAX_PASSENGERS_POSSIBLE;
    }
}
