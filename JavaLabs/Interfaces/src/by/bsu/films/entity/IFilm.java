package by.bsu.films.entity;

import by.bsu.films.exception.CastException;

import java.time.LocalDate;
import java.util.List;

public interface IFilm {
    String developScenario();
    void castActors(List<Actor> actors, int x) throws CastException;
    String findProducers();
    String createFilm();
    void releaseFilm(LocalDate start);
    String showActorSquad();
}
