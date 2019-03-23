package by.bsu.trains.handlers;

import by.bsu.trains.entity.Train;

import java.time.LocalTime;
import java.util.ArrayList;

public class trainSelector {
    //1)список поездов, следующих до заданного пункта назначения

    /**Get list of trains that go to a certain destination point
     *
     * @param trains        list of all trains
     * @param destPoint     marker of destination point
     * @return              list of suitable trains
     */
    public static ArrayList<Train> getTrainsWithDestPoint(ArrayList<Train> trains, String destPoint){
        ArrayList<Train> resultList = new ArrayList<>();
        trains.forEach(train ->{
            if(train.getDestPoint().equals(destPoint)){
                resultList.add(train);
            }
        });
        return resultList;
    }

    //2)список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа

    /**Get list of trains that go to a certain destination point
     * and depart after certain time in HH:MM
     * @param trains        list of all trains
     * @param destPoint     marker of destination point
     * @param depTime       marker of departure time
     * @return              list of suitable trains
     */
    public static ArrayList<Train> getTrainsWithDestPointAndDepTime(ArrayList<Train> trains, String destPoint, LocalTime depTime){
        ArrayList<Train> resultList = new ArrayList<>();
        trains.forEach(train ->{
            if(train.getDestPoint().equals(destPoint) && train.getDepTime().compareTo(depTime) > 0){ //>0 means greater
                resultList.add(train);
            }
        });
        return resultList;
    }

    //3)список поездов, следующих до заданного пункта назначения и имеющих общие места

    /**Get list of trains that go to a certain destination point
     * and have amount COMMON type of seats greater than 0
     * @param trains        list of all trains
     * @param destPoint     marker of destination point
     * @return              list of suitable trains
     */
    public static ArrayList<Train> getTrainsWithDestPointAndSeats(ArrayList<Train> trains, String destPoint){
        ArrayList<Train> resultList = new ArrayList<>();
        trains.forEach(train ->{
            if(train.getDestPoint().equals(destPoint) && train.getSeatsCommon() > 0){
                resultList.add(train);
            }
        });
        return resultList;
    }

    public static ArrayList<Train> getEarliestTrain(ArrayList<Train> trains){
        ArrayList<Train> resultList = new ArrayList<>();
        LocalTime temp = LocalTime.of(23,59);
        //get the earliest departure time
        for (Train train : trains){
            if(temp.compareTo(train.getDepTime()) > 0) temp = train.getDepTime();
        }
        //compose a list of earliest trains
        for (Train train : trains){
            if(train.getDepTime() == temp) resultList.add(train);
        }
        return resultList;
    }

}
