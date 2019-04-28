package by.bsu.taxipark.entity;

import by.bsu.taxipark.entity.fewPassengersCar.CarClassification;

import java.util.Objects;

/**Main abstract class of this app */
public abstract class Auto {
    protected String model;
    protected int year;
    protected double fuelConsumption;
    protected double price;
    protected int maxPassengers;
    protected int maxSpeed;
    protected CarClassification carClass;
    protected boolean airConditioning = false;
    protected boolean beverages = false;

    public Auto(){
        this.model = "";
        this.carClass = CarClassification.DEFAULT;
    }
    public Auto(String model, int year, double fuelConsumption, double price, int maxPassengers, int maxSpeed,
                boolean airConditioning, boolean beverages) {
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.airConditioning = airConditioning;
        this.beverages = beverages;
    }

    public Auto(String model, int year, double fuelConsumption, double price, int maxPassengers, int maxSpeed,
                CarClassification carClass, boolean airConditioning, boolean beverages) {
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.carClass = carClass;
        this.airConditioning = airConditioning;
        this.beverages = beverages;
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

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setCarClass(CarClassification carClass) {
        this.carClass = carClass;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public CarClassification getCarClass() {
        return carClass;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public boolean isBeverages() {
        return beverages;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxPassengers=" + maxPassengers +
                ", maxSpeed=" + maxSpeed +
                ", carClass=" + carClass +
                ", airConditioning=" + airConditioning +
                ", beverages=" + beverages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return year == auto.year &&
                Double.compare(auto.fuelConsumption, fuelConsumption) == 0 &&
                Double.compare(auto.price, price) == 0 &&
                maxPassengers == auto.maxPassengers &&
                maxSpeed == auto.maxSpeed &&
                airConditioning == auto.airConditioning &&
                beverages == auto.beverages &&
                Objects.equals(model, auto.model) &&
                carClass == auto.carClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, fuelConsumption, price, maxPassengers, maxSpeed, carClass, airConditioning, beverages);
    }


}
