package by.bsu.taxipark.entity.fewPassengersCar;

import by.bsu.taxipark.entity.CarClassification;

/**It's a fewPassengersCar with airConditioning and beverages*/
public class ComfortCar extends FewPassengersCar {
    private boolean airConditioning;//кондиционер
    private boolean beverages;//напитки

    public ComfortCar(){
        super();
        this.airConditioning = true;
        this.beverages = true;
    }
    public ComfortCar(String model, int year, double fuelConsumption, double price, int maxSpeed, int luggage_weight, boolean airConditioning, boolean beverages) {
        super(model, year, fuelConsumption, price, maxSpeed, luggage_weight);
        this.airConditioning = airConditioning;
        this.beverages = beverages;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public boolean isBeverages() {
        return beverages;
    }

    @Override
    public String toString() {
        return "ComfortCar{" +
                "airConditioning=" + airConditioning +
                ", beverages=" + beverages +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
