package by.bsu.taxipark.tasks;

import by.bsu.taxipark.entity.Auto;

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
    public static List<Auto> getAutoBySpeedLimit(int MIN_SPEED, int MAX_SPEED, List<Auto> carPool){
        List<Auto> resultPool = new ArrayList<>();
        for (Auto car : carPool){
            if(car.getMaxSpeed() > MIN_SPEED && car.getMaxSpeed() < MAX_SPEED)
                resultPool.add(car);
        }
        return resultPool;
    }
}
