package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Auto;

import java.util.List;

public class CarPriceCalculator {

    /** This method calculates sum of my taxi park
     * @param cars  list of cars
     * @return      total sum of taxi park
     */
    public static double getSumOfTaxiPark(List<Auto> cars){
        double sum = 0.0;
        for (Auto car : cars) sum += car.getPrice();
        return sum;
    }
}
