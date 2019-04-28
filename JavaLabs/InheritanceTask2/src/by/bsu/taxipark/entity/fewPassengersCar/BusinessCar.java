package by.bsu.taxipark.entity.fewPassengersCar;

/**It's a fewPassengersCar with airConditioning, beverages and maxPassengers = 2 */
public class BusinessCar extends FewPassengersCar {
    public BusinessCar() {
        this.model = "";
    }

    public BusinessCar(String model, int year, double fuelConsumption, double price, int maxSpeed){
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.maxPassengers = 2;
        this.carClass = CarClassification.BUSINESS;
        this.airConditioning = true;
        this.beverages = true;
    }
}
