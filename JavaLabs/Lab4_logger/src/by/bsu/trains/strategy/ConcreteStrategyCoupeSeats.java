package by.bsu.trains.strategy;

import by.bsu.trains.entity.Train;

import java.util.ArrayList;

/**Methods of this concrete strategy are applied
 * when strategy was set to coupeSeats
 */
public class ConcreteStrategyCoupeSeats implements Strategy {
    @Override
    public ArrayList<Train> trainSelection(ArrayList<Train> trains) {
        ArrayList<Train> result = new ArrayList<>();
        int maxCoupe = 0;
        for (Train train : trains){
            if(train.getSeatsCoupe() > maxCoupe) maxCoupe = train.getSeatsCoupe();
        }

        final int wrapMaxCoupe = maxCoupe;
        trains.forEach(t->{
            if(t.getSeatsCoupe() == wrapMaxCoupe) result.add(t);
        });
        return result;
    }

    @Override
    public int seatsCounter(ArrayList<Train> trains) {
        int result = 0;
        for (Train train : trains) result+= train.getSeatsCoupe();
        return result;
    }
}
