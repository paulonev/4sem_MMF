package by.bsu.trains.Factory;

import by.bsu.trains.entity.Train;
import by.bsu.trains.exceptions.NotValidAmountOfSeatsException;

public class TrainsFactory {
    /**This is a factory for all trains in this app.
     * Objects will be created if and only if they
     * pass through validation
     *
     * @param _trainId      train number
     * @param _destPoint    a place to travel to
     * @param _seatsCommon  amount of seats of type :common
     * @param _seatsCoupe   amount of seats of type :coupe
     * @param _seatsPl      amount of seats of type :platscart
     * @param _seatsLux     amount of seats of type :lux
     * @param hour          departure hour
     * @param minute        departure minute
     * @return              newly created instance of class Train
     * @throws NotValidAmountOfSeatsException   depend on amount of seats
     */
    public Train trainFactory( long _trainId,String _destPoint,int _seatsCommon, int _seatsCoupe,
                               int _seatsPl, int _seatsLux, int hour, int minute)
            throws NotValidAmountOfSeatsException {

        //check for valid info about seats in train
        if((_seatsCommon < 0 || _seatsCoupe < 0 || _seatsPl < 0 || _seatsLux < 0)||
                _seatsCommon+_seatsCoupe + _seatsLux + _seatsLux == 0) throw new NotValidAmountOfSeatsException("" +
                "Wrong amount of seats(amount of each category of seats is >= 0 and total seats > 0)" );
        else{
            return new Train(_trainId,_destPoint,_seatsCommon,_seatsCoupe,_seatsPl,_seatsLux,hour,minute);
        }
    }
}
