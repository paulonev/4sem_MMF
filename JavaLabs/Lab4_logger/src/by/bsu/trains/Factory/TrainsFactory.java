package by.bsu.trains.Factory;

import by.bsu.trains.entity.Train;
import by.bsu.trains.exceptions.NotValidAmountOfSeatsException;

public class trainsFactory{
    public Train trainFactory(String _destPoint, long _trainId, int hour, int minute,
                              int _seatsCommon, int _seatsCoupe, int _seatsPl, int _seatsLux)
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
