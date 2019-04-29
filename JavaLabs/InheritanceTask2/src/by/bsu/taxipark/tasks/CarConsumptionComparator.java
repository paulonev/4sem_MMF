package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Car;

import java.util.Comparator;

public class CarConsumptionComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return (int) (o1.getFuelConsumption() - o2.getFuelConsumption());
    }
}
