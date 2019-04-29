package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Car;

import java.util.List;

public class CarPriceCalculator {

    /** This method calculates sum of my taxi park
     * @param cars  list of cars
     * @return      total sum of taxi park
     */
    public static double getSumOfTaxiPark(List<Car> cars){
        double sum = 0.0;
        for (Car car : cars) sum += car.getPrice();
        return sum;
    }
}
