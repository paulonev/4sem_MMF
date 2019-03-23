package by.bsu.trains.strategy;

import by.bsu.trains.entity.Train;

import java.util.ArrayList;

/**It's an interface(abstract class that contains methods to be
 * realized between concrete strategies).
 *
 * @author Paul Okunev
 * @version  1.0
 */
public interface Strategy {
    ArrayList<Train> trainSelection(ArrayList<Train> trains);
    int seatsCounter(ArrayList<Train> trains);
}
