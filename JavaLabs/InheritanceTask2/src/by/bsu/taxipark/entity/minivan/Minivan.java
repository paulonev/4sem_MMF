package by.bsu.taxipark.entity.minivan;

import by.bsu.taxipark.entity.Auto;
import by.bsu.taxipark.entity.fewPassengersCar.CarClassification;

public class Minivan extends Auto {
    public Minivan() {
        this.model = "";
    }

    public Minivan(String model, int year, double fuelConsumption, double price, int maxSpeed){
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.maxPassengers = 10;
        this.carClass = CarClassification.VAN;
        this.airConditioning = true;
    }
}
