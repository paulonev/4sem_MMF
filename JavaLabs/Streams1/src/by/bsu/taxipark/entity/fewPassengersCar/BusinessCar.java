package by.bsu.taxipark.entity.fewPassengersCar;

/**It's a fewPassengersCar with airConditioning, beverages and batteryCharger */
public class BusinessCar extends FewPassengersCar {
    private boolean airConditioning;//кондиционер
    private boolean beverages;//напитки
    private boolean batteryCharger;//докстанция

    public BusinessCar(){
        super();
        this.beverages = true;
        this.airConditioning = true;
        this.batteryCharger = true;
    }
    public BusinessCar(String model, int year, double fuelConsumption, double price, int maxSpeed, int luggage_weight, boolean airConditioning, boolean beverages, boolean batteryCharger) {
        super(model, year, fuelConsumption, price, maxSpeed, luggage_weight);
        this.airConditioning = airConditioning;
        this.beverages = beverages;
        this.batteryCharger = batteryCharger;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public boolean isBeverages() {
        return beverages;
    }

    public boolean isBatteryCharger() {
        return batteryCharger;
    }

    @Override
    public String toString() {
        return "BusinessCar{" +
                "airConditioning=" + airConditioning +
                ", beverages=" + beverages +
                ", batteryCharger=" + batteryCharger +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
