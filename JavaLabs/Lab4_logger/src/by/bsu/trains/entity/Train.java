package by.bsu.trains.entity;

import java.time.LocalTime;
import java.util.Objects;

/**This class describes Train as key entity of this app.
 *
 * @author Paul Okunev
 * @version 1.0
 * @since JDK 9.0
 */
public class Train {
    private long trainId;
    private String destPoint;
    private LocalTime depTime;
    private int seatsCommon;
    private int seatsCoupe;
    private int seatsPl;
    private int seatsLux;

    public Train(){
        destPoint = null;
        depTime = null;
    }

    public Train(long trainId, String destPoint, int seatsCommon, int seatsCoupe,
                 int seatsPl, int seatsLux, int hour, int minute) {
        this.trainId = trainId;
        this.destPoint = destPoint;
        this.depTime = LocalTime.of(hour,minute); //!!!
        this.seatsCommon = seatsCommon;
        this.seatsCoupe = seatsCoupe;
        this.seatsPl = seatsPl;
        this.seatsLux = seatsLux;
    }

    public long getId() {return trainId;}

    public void setId(long id) {this.trainId = id;}

    public String getDestPoint() {return destPoint;}

    public void setDestPoint(String destPoint) {this.destPoint = destPoint;}

    public int[] getDepTimeAsArray() {
        return new int[]{
                depTime.getHour(),
                depTime.getMinute()
        };
    }

    public LocalTime getDepTime(){
        return this.depTime;
    }

    public void setDepTime(int hour, int minute) {
        this.depTime = LocalTime.of(hour, minute);
    }

    public int getSeatsCommon() {return seatsCommon;}

    public void setSeatsCommon(int seatsCommon) {this.seatsCommon = seatsCommon;}

    public int getSeatsCoupe() {return seatsCoupe;}

    public void setSeatsCoupe(int seatsCoupe) {this.seatsCoupe = seatsCoupe;}

    public int getSeatsPl() {return seatsPl;}

    public void setSeatsPl(int seatsPl) {this.seatsPl = seatsPl;}

    public int getSeatsLux() {return seatsLux;}

    public void setSeatsLux(int seatsLux) {this.seatsLux = seatsLux;}

    //method is used for comparing objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainId == train.trainId &&
                seatsCommon == train.seatsCommon &&
                seatsCoupe == train.seatsCoupe &&
                seatsPl == train.seatsPl &&
                seatsLux == train.seatsLux &&
                (destPoint != null && destPoint.equals(train.destPoint)) &&
                (depTime != null && depTime.equals(train.depTime));
    }

    //method is used for generating unique code of object
    @Override
    public int hashCode() {
        return Objects.hash(trainId, destPoint, depTime, seatsCommon, seatsCoupe, seatsPl, seatsLux);
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();

        out.append(" Поезд №" + this.trainId + "\n"+
        "Общих мест: " +this.seatsCommon + " " +
        "Мест купе: " +this.seatsCoupe + " "+
        "Мест плацкарт: " +this.seatsPl + " "+
        "Мест люкс: " +this.seatsLux + " "+
        "Место прибытия: " +this.destPoint + " " +
        "Время отправления: " + this.getDepTimeAsArray()[0] + ":" + this.getDepTimeAsArray()[1] + "\n");

        return out.toString();
    }
}
