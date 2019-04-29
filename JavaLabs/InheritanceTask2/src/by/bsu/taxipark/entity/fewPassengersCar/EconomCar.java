package by.bsu.taxipark.entity.fewPassengersCar;

/**It's a fewPassengersCar with airConditioning*/
public class EconomCar extends FewPassengersCar{
    private boolean airConditioning;//кондиционер

    public EconomCar(){
        super();
        this.airConditioning = true;
    }

    public EconomCar(String model, int year, double fuelConsumption, double price, int maxSpeed, int luggage_weight, boolean airConditioning) {
        super(model, year, fuelConsumption, price, maxSpeed, luggage_weight);
        this.airConditioning = airConditioning;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    @Override
    public String toString() {
        return "EconomCar{" +
                "airConditioning=" + airConditioning +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
