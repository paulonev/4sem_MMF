package by.bsu.trains.strategy;

import by.bsu.trains.entity.Train;

import java.util.ArrayList;

/**Methods of this concrete strategy are applied
 * when strategy was set to plSeats
 */
public class ConcreteStrategyPlSeats implements Strategy {
    @Override
    public ArrayList<Train> trainSelection(ArrayList<Train> trains) {
        ArrayList<Train> result = new ArrayList<>();
        int maxPl = 0;
        for (Train train : trains){
            if(train.getSeatsPl() > maxPl) maxPl = train.getSeatsPl();
        }

        final int wrapMaxPl = maxPl;
        trains.forEach(t->{
            if(t.getSeatsPl() == wrapMaxPl) result.add(t);
        });
        return result;
    }

    @Override
    public int seatsCounter(ArrayList<Train> trains) {
        int result = 0;
        for (Train train : trains) result+= train.getSeatsPl();
        return result;
    }
}
