package by.bsu.trains.strategy;

import by.bsu.trains.entity.Train;

import java.util.ArrayList;

/**Methods of this concrete strategy are applied
 * when strategy was set to luxSeats
 */
public class ConcreteStrategyLuxSeats implements Strategy {
    @Override
    public ArrayList<Train> trainSelection(ArrayList<Train> trains) {
        ArrayList<Train> result = new ArrayList<>();
        int maxLux = 0;
        for (Train train : trains){
            if(train.getSeatsLux() > maxLux) maxLux = train.getSeatsLux();
        }

        final int wrapMaxLux = maxLux;
        trains.forEach(t->{
            if(t.getSeatsLux() == wrapMaxLux) result.add(t);
        });
        return result;
    }
    @Override
    public int seatsCounter(ArrayList<Train> trains) {
        int result = 0;
        for (Train train : trains) result+= train.getSeatsLux();
        return result;
    }
}
