package by.bsu.lab4.model;

import java.time.LocalTime;
import java.util.Objects;

/**This class is used to describe WHAT IS DATABASE ENTITY in java app
 * It's a descriptive class of each element of the table Trains
 *
 */
public class Train {
    private long id;
    private String arrivalPoint;
    private long trainNumber;
    private LocalTime departureTime;
    private int seatsAll;
    private int seatsCoupe;
    private int seatsPl;
    private int seatsLux;

    public Train(){}

    public Train(long id, String arrivalPoint, long trainNumber, LocalTime departureTime, int seatsAll, int seatsCoupe, int seatsPl, int seatsLux) {
        this.id = id;
        this.arrivalPoint = arrivalPoint;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.seatsAll = seatsAll;
        this.seatsCoupe = seatsCoupe;
        this.seatsPl = seatsPl;
        this.seatsLux = seatsLux;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return id == train.id;
       }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public long getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(long trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getSeatsAll() {
        return seatsAll;
    }

    public void setSeatsAll(int seatsAll) {
        this.seatsAll = seatsAll;
    }

    public int getSeatsCoupe() {
        return seatsCoupe;
    }

    public void setSeatsCoupe(int seatsCoupe) {
        this.seatsCoupe = seatsCoupe;
    }

    public int getSeatsPl() {
        return seatsPl;
    }

    public void setSeatsPl(int seatsPl) {
        this.seatsPl = seatsPl;
    }

    public int getSeatsLux() {
        return seatsLux;
    }

    public void setSeatsLux(int seatsLux) {
        this.seatsLux = seatsLux;
    }
}
