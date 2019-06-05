package by.bsu.films;

import by.bsu.films.build.ActorsListBuilder;
import by.bsu.films.entity.Actor;
import by.bsu.films.entity.Comedy;
import by.bsu.films.entity.DomesticFilm;
import by.bsu.films.exception.CastException;
import by.bsu.films.exception.WrongDataException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static String filePath = "E:\\4sem_MMF\\JavaLabs\\Interfaces\\data\\actors.txt";

    public static void main(String[] args){
        try{
            List<Actor> actorsAvailable = ActorsListBuilder.initializeActorsList(filePath);
            Comedy film1 = new Comedy("Lapyramid",116,"comedy","Kazantsev",3.0,16);
            /*1-блок написания сценария*/System.out.println(film1.developScenario());
            /*2-блок просмотра актёров*/film1.castActors(actorsAvailable,4);
            /*3-блок нахождения продюсеров*/System.out.println(film1.findProducers());
            /*4-блок назначения даты начала и конца съёмок*/
            film1.releaseFilm(LocalDate.of(2017,8,12)); //передаём туда дату начала съёмок
            /*5-Блок создания фильма(отснять и смонтировать*/System.out.println(film1.createFilm());
            /*6-Показать результаты*/System.out.println(film1.toString());

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (WrongDataException|CastException ex){
            System.out.println(ex);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage() + ". Unable to create a film");
        }
    }
}
