package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class SpeedLimitsCarsSelector {

    /**This method filters cars list according to speed edges
     *
     * @param MIN_SPEED     lower edge
     * @param MAX_SPEED     upper edge
     * @param carPool       taxi park where to select cars from
     * @return              list that meets the requirements
     */
    public static List<Car> getAutoBySpeedLimit(int MIN_SPEED, int MAX_SPEED, List<Car> carPool){
        List<Car> resultPool = new ArrayList<>();
        for (Car car : carPool){
            if(car.getMaxSpeed() > MIN_SPEED && car.getMaxSpeed() < MAX_SPEED)
                resultPool.add(car);
        }
        return resultPool;
    }
}
