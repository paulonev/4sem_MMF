package by.bsu.trains.strategy;

import by.bsu.trains.entity.Train;

import java.util.ArrayList;

/**This is the class describing what could
 * be done with each type of strategy.
 * Here we can set strategy, select trains with max amount of certain types of seats
 * and return amount of a certain type of seats of all trains.
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**For each type of strategy find trains with max amount of seats
     * Each strategy performs it's method.
     * @param trains    list of all trains
     * @return          list of suitable trains
     */
    public ArrayList<Train> trainsSelectionStrategy(ArrayList<Train> trains){
        return strategy.trainSelection(trains);
    }

    /**For each type of strategy find overall amount of seats
     * Each strategy performs it's method.
     * @param trains    list of all trains
     * @return          list of suitable trains
     */
    public int seatsCounterStrategy(ArrayList<Train> trains){
        return strategy.seatsCounter(trains);
    }
}
