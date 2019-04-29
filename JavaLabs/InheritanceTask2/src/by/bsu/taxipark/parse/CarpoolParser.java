package by.bsu.taxipark.parse;

import by.bsu.taxipark.entity.CarClassification;
import by.bsu.taxipark.exception.WrongDataException;
import by.bsu.taxipark.util.FileTags;
import by.bsu.taxipark.validator.CarValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CarpoolParser {
    private String text;
    private static Pattern p = Pattern.compile(" |=");

    public CarpoolParser(String text) {
        this.text = text.toUpperCase();
    }

    public String getText() { return text; }

    /**This method takes car class parameter from file and creates enum-parameter from it
     *
     * @return  car classification: econom, comfort, business, minivan or else
     * @throws WrongDataException if file's string doesn't represent a car or invalid CL parameter in file
     */
    public CarClassification takeCarClass() throws WrongDataException {
        if(CarValidator.isStringACar(this.text)) {
            int index = text.indexOf(FileTags.CL) + FileTags.CL.length();//индекс начала данных
            Scanner scanner = new Scanner(text.substring(index));//ставим scanner в индекс и начинаем считывать
            scanner.useDelimiter(p);//разбивает строку на эл-ты находящиеся между " " и =
            String carClassStr = scanner.next();//считает первый эл-т
            if(CarValidator.isValidCarClass(carClassStr)) {
                return CarClassification.valueOf(carClassStr);
            } else throw new WrongDataException("Not valid car classification");

        } else {
            throw new WrongDataException("Not valid car parameters");
        }
    }

    /**This method takes car model parameter from file and creates String value from it
     *
     * @return  car's MODEL value
     * @throws WrongDataException if file's string doesn't represent a car
     */
    public String takeCarModel() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
           int index = text.indexOf(FileTags.MODEL) + FileTags.MODEL.length();
           Scanner scanner = new Scanner(text.substring(index));
           scanner.useDelimiter(p);
           return scanner.next();
        }else throw new WrongDataException("Not valid car parameters");
    }

    /**This method takes car YEAR parameter from file and creates Int value from it
     *
     * @return  car's YEAR of release value
     * @throws WrongDataException if file's string doesn't represent a car or invalid YEAR parameter in file
     */
    public int takeCarYear() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.YEAR) + FileTags.YEAR.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextInt()){
                int year = scanner.nextInt();
                if(CarValidator.isValidCarYear(year)) return year;
                else throw new WrongDataException("Check possible edges for car year in TaxiParkConstants");
            }
            else throw new WrongDataException("Year parameter can't be converted to number");
        }else throw new WrongDataException("Not valid car parameters");
    }

    /**This method takes car fuel consumption parameter from file and create double value from it
     *
     * @return  car's FUEL CONSUMPTION value
     * @throws WrongDataException if file's string doesn't represent a car or invalid CONSUMPTION parameter in file
     */
    public double takeCarConsumption() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.CONSUMPTION) + FileTags.CONSUMPTION.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextDouble()){
                double cons = scanner.nextDouble();
                if(CarValidator.isValidConsumption(cons)) return cons;
                else throw new WrongDataException("Check possible edges for consumption in TaxiParkConstants");
            }
            else throw new WrongDataException("Consumption parameter can't be converted to number");
        }else throw new WrongDataException("Not valid car parameters");
    }

    /**This method takes car price parameter from file and create double value from it
     *
     * @return  car's PRICE value
     * @throws WrongDataException if file's string doesn't represent a car or invalid PRICE parameter in file
     */
    public double takeCarPrice() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.PRICE) + FileTags.PRICE.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextDouble()){
                double pr = scanner.nextDouble();
                if(CarValidator.isValidPrice(pr)) return pr;
                else throw new WrongDataException("Check possible edges for price in TaxiParkConstants");
            }
            else throw new WrongDataException("Price parameter can't be converted to number");
        }else throw new WrongDataException("Not valid car parameters");
    }

    /**This method takes car speed parameter from file and create int value from it
     *
     * @return  car's MAX_SPEED value
     * @throws WrongDataException if file's string doesn't represent a car or invalid MAX_SPEED parameter in file
     */
    public int takeCarSpeed() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.MAX_SPEED) + FileTags.MAX_SPEED.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextInt()){
                int ms = scanner.nextInt();
                if(CarValidator.isValidMaxSpeed(ms)) return ms;
                else throw new WrongDataException("Check possible edges for maxSpeed in TaxiParkConstants");
            }
            else throw new WrongDataException("MaxSpeed parameter can't be converted to number");
        }else throw new WrongDataException("Not valid car parameters");
    }

    /**This method takes car luggage_weigth parameter from file and create int value from it
     * Used only for fewPassengers cars
     * @return  car's LUGGAGE_WEIGHT value
     * @throws WrongDataException if file's string doesn't represent a car or invalid LUGGAGE_WEIGHT parameter in file
     */
    public int takeCarLuggageWeight() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.LUGGAGE_WEIGHT) + FileTags.LUGGAGE_WEIGHT.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextInt()){
                int lw = scanner.nextInt();
                if(CarValidator.isValidLuggage_Weight(lw)) return lw;
                else throw new WrongDataException("Check possible edges for luggage_weight in TaxiParkConstants");
            }
            else throw new WrongDataException("Luggage_weight parameter can't be converted to number");
        }else throw new WrongDataException("Not valid car parameters");
    }

    public boolean takeCarConditioning() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.AIR_CONDITIONING) + FileTags.AIR_CONDITIONING.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextBoolean()) return scanner.nextBoolean();
            else throw new WrongDataException("AirConditioning parameter is not TRUE/FALSE");
        }else throw new WrongDataException("Not valid car parameters");
    }

    public boolean takeCarBeverages() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.BEVERAGES) + FileTags.BEVERAGES.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextBoolean()) return scanner.nextBoolean();
            else throw new WrongDataException("Beverages parameter is not TRUE/FALSE");
        }else throw new WrongDataException("Not valid car parameters");
    }

    public boolean takeCarBatteryCharger() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.BATTERY_CHARGER) + FileTags.BATTERY_CHARGER.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextBoolean()) return scanner.nextBoolean();
            else throw new WrongDataException("BatteryCharger parameter is not TRUE/FALSE");
        }else throw new WrongDataException("Not valid car parameters");
    }

    /**This method takes car maxPassengers parameter from file and create int value from it
     *  Used only for minivans
     * @return  minivan's MAX_PASSENGERS value
     * @throws WrongDataException if file's string doesn't represent a car or invalid MAX_PASSENGERS parameter in file
     */
    public int takeCarMaxPassengers() throws WrongDataException{
        if(CarValidator.isStringACar(this.text)){
            int index = text.indexOf(FileTags.MAX_PASSENGERS) + FileTags.MAX_PASSENGERS.length();
            Scanner scanner = new Scanner(text.substring(index));
            scanner.useDelimiter(p);
            if(scanner.hasNextInt()){
                int mp = scanner.nextInt();
                if(CarValidator.isValidMaxPassengers(mp)) return mp;
                else throw new WrongDataException("Check possible edges for maxPassengers in TaxiParkConstants");
            }
            else throw new WrongDataException("Minivan's maxPassengers parameter can't be converted to number");
        }else throw new WrongDataException("Not valid car parameters");
    }

}
