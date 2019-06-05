package by.bsu.taxipark.storage;

import by.bsu.taxipark.entity.Car;
import by.bsu.taxipark.exception.StorageException;

import java.util.LinkedList;

public class CarStorage {
    private LinkedList<Car> cars;
    private static final CarStorage INSTANCE = new CarStorage();

    private CarStorage() {this.cars = new LinkedList<>();}

    public static CarStorage getInstance() { return INSTANCE; }

    public void addCar (Car car) { cars.addLast(car);}

    public Car takeCar() throws StorageException {
        if(!cars.isEmpty()){
            return cars.removeFirst();
        }else{
            throw new StorageException("CarStorage is empty");
        }
    }

    public int countOfCars(){
        return this.cars.size();
    }

    public boolean isEmpty(){
        return cars.isEmpty();
    }
}
