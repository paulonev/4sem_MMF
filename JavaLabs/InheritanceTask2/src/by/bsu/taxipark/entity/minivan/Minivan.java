package by.bsu.taxipark.entity.minivan;

import by.bsu.taxipark.entity.Car;

/*Minivan - car with ability to transport several passengers*/
public class Minivan extends Car {
    private int maxPassengers;

    public Minivan() {
        super();
    }

    public Minivan(String model, int year, double fuelConsumption, double price, int maxSpeed, int maxPassengers) {
        super(model, year, fuelConsumption, price, maxSpeed);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public String toString() {
        return "Minivan{" +
                "maxPassengers=" + maxPassengers +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
