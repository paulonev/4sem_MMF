package by.bsu.taxipark.entity.fewPassengersCar;

/**It's a fewPassengersCar without airConditioning, without beverages and maxPassengers = 4 */
public class EconomCar extends FewPassengersCar{
    public EconomCar() {
        this.model = "";
    }

    public EconomCar(String model, int year, double fuelConsumption, double price, int maxSpeed){
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.maxPassengers = 4;
        this.carClass = CarClassification.ECONOM;
    }
}
