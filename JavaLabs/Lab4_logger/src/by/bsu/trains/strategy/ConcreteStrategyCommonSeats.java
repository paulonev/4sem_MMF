package by.bsu.trains.strategy;

import by.bsu.trains.entity.Train;

import java.util.ArrayList;

/**Methods of this concrete strategy are applied
 * when strategy was set to commonSeats
 */
public class ConcreteStrategyCommonSeats implements Strategy {
    @Override
    public ArrayList<Train> trainSelection(ArrayList<Train> trains) {
        ArrayList<Train> result = new ArrayList<>();
        int maxCommon = 0;
        for (Train train : trains){
            if(train.getSeatsCommon() > maxCommon) maxCommon = train.getSeatsCommon();
        }

        final int wrapMaxCommon = maxCommon;
        trains.forEach(t->{
            if(t.getSeatsCommon() == wrapMaxCommon) result.add(t);
        });
        return result;
    }

    @Override
    public int seatsCounter(ArrayList<Train> trains) {
        int result = 0;
        for (Train train : trains) result+= train.getSeatsCommon();
        return result;
    }
}
