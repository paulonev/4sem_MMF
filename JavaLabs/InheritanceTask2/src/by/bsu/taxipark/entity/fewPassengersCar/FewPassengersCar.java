package by.bsu.taxipark.entity.fewPassengersCar;

import by.bsu.taxipark.entity.Car;

/**This abstract class is for cars that can carry luggage
 * They are: econom, comfort and business cars
 */
public abstract class FewPassengersCar extends Car {
    private int luggage_weight;//in kilos

    public FewPassengersCar(){}

    public FewPassengersCar(int luggage_weight) {
        this.luggage_weight = luggage_weight;
    }

    public FewPassengersCar(String model, int year, double fuelConsumption, double price, int maxSpeed, int luggage_weight) {
        super(model, year, fuelConsumption, price, maxSpeed);
        this.luggage_weight = luggage_weight;
    }

    public int getLuggage_weight() {
        return luggage_weight;
    }
}
