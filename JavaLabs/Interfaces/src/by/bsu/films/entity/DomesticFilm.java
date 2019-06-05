package by.bsu.films.entity;

import by.bsu.films.utils.CinemaGenres;
import by.bsu.films.constants.FilmConstants;
import by.bsu.films.exception.CastException;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Pavel Okunev
 * @version 1.0
 *
 * Создать и реализовать интерфейсы, также использовать наследование и полиморфизм для следующей предметной области
 * interface Фильм(IFilm - class Отечественный Фильм(Domestic Film) - class Комедия(Comedy).
 * @see by.bsu.films.entity.IFilm
 * @see by.bsu.films.entity.DomesticFilm
 * @see by.bsu.films.entity.Comedy
 *
 */
public class DomesticFilm implements IFilm {
    protected String title;
    protected int minutesLength;
    protected CinemaGenres genre;
    protected String filmDirector;
    protected LocalDate releaseDate;
    protected ArrayList<Actor> actorSquad; //актёрский состав фильма

    public DomesticFilm(){
        this.title = "no title";
        this.genre = null;
        this.filmDirector = "no filmDirector";
        this.releaseDate = null;
    }

    public DomesticFilm(String title, int minutesLength, String genre, String filmDirector) throws
            IllegalArgumentException{
        this.title = title;
        this.minutesLength = minutesLength;
        this.genre = CinemaGenres.valueOf(genre.toUpperCase());
        this.filmDirector = filmDirector;
        this.actorSquad = new ArrayList<>();
    }

    @Override
    public String developScenario() {
        return "Scenario has been developed";
    }

    /**
     * This method is used to select actors for new film
     * @param actors    list of available actor
     * @param N         amount of actors required
     */
    @Override
    public void castActors(List<Actor> actors, int N) throws CastException{
        Collections.shuffle(actors);
        for (int i=0; i<N; i++){
            this.actorSquad.add(actors.get(i));
        }
    }

    @Override
    public String findProducers() {
        return "Producers were found";
    }

    @Override
    public String createFilm() {
        return "Film creation was finished";
    }

    //выпустить фильм означает назначить дату выпуска, т.е задать поле releaseDate
    //дата выпуска не может быть ранее MIN_DAYS_TO_RELEASE дней после начала съёмок
    //на вход: дата начала съёмок
    @Override
    public void releaseFilm(LocalDate startDate) {
        this.releaseDate = startDate.plusDays(FilmConstants.MIN_DAYS_TO_RELEASE);
    }

    @Override
    public String showActorSquad() {
        StringBuilder str = new StringBuilder();
        for (Actor actor : this.actorSquad){
            str.append(actor.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinutesLength() {
        return minutesLength;
    }

    public void setMinutesLength(int minutesLength) {
        this.minutesLength = minutesLength;
    }

    public CinemaGenres getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = CinemaGenres.valueOf(genre);
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Film - '"+title+"' {" +
                "\nlength= " + minutesLength + " mins" +
                "\ngenre= " + genre +
                "\nfilmDirector= " + filmDirector +
                "\nreleaseDate= " + releaseDate +
                "\nactorSquad: {\n" + showActorSquad() + "}" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomesticFilm that = (DomesticFilm) o;
        return minutesLength == that.minutesLength &&
                Objects.equals(title, that.title) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(filmDirector, that.filmDirector) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, minutesLength, genre, filmDirector, releaseDate);
    }

}
