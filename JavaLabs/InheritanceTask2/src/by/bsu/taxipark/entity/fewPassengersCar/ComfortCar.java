package by.bsu.taxipark.entity.fewPassengersCar;

/**It's a fewPassengersCar with airConditioning, without beverages and maxPassengers = 4 */
public class ComfortCar extends FewPassengersCar {
    public ComfortCar() {
        this.model = "";
    }

    public ComfortCar(String model, int year, double fuelConsumption, double price, int maxSpeed){
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.maxPassengers = 4;
        this.carClass = CarClassification.COMFORT;
        this.airConditioning = true;
    }
}
