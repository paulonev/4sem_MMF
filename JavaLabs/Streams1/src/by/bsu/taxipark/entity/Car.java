package by.bsu.taxipark.entity;

import java.io.Serializable;
import java.util.Objects;

/**Main abstract class of this app */
public abstract class Car implements Serializable{
    protected int year;
    protected String model;
    protected double fuelConsumption;
    protected double price;
    protected int maxSpeed;
    private static final long serialVersionUID = 2L;
    //private static String type;

    public Car(){
        this.model = "";
    }

    public Car(String model, int year, double fuelConsumption, double price, int maxSpeed) {
        //this.type = type;
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    /*setters*/
    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //public static void setType(String type) {Car.type = type;}

    /*getters*/
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                Double.compare(car.price, price) == 0 &&
                maxSpeed == car.maxSpeed &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, fuelConsumption, price, maxSpeed);
    }
}
