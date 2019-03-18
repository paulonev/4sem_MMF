package by.bsu.trains.handlers;

import by.bsu.trains.entity.Train;

import java.time.LocalTime;
import java.util.ArrayList;

public class trainSelector {
    //1)список поездов, следующих до заданного пункта назначения
    public ArrayList<Train> getTrainsWithDestPoint(ArrayList<Train> trains, String destPoint){
        ArrayList<Train> resultList = new ArrayList<>();
        trains.forEach(train ->{
            if(train.getDestPoint().equals(destPoint)){
                resultList.add(train);
            }
        });
        return resultList;
    }

    //2)список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа
    public ArrayList<Train> getTrainsWithDestPointAndDepTime(ArrayList<Train> trains, String destPoint, LocalTime depTime){
        ArrayList<Train> resultList = new ArrayList<>();
        trains.forEach(train ->{
            if(train.getDestPoint().equals(destPoint) && train.getDepTime().equals(depTime)){
                resultList.add(train);
            }
        });
        return resultList;
    }

    //3)список поездов, следующих до заданного пункта назначения и имеющих общие места
    public ArrayList<Train> getTrainsWithDestPointAndSeats(ArrayList<Train> trains, String destPoint, int seatsCommon){
        ArrayList<Train> resultList = new ArrayList<>();
        trains.forEach(train ->{
            if(train.getDestPoint().equals(destPoint) && train.getSeatsCommon() == seatsCommon){
                resultList.add(train);
            }
        });
        return resultList;
    }
}
