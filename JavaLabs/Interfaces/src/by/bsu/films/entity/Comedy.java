package by.bsu.films.entity;

import by.bsu.films.utils.CinemaGenres;
import by.bsu.films.exception.CastException;

import java.util.Collections;
import java.util.List;

public class Comedy extends DomesticFilm{
    private double laughterVolume; //уровень смеха в кинозале
    private int ageLimits; //возрастная категория комедии

    public Comedy(){
        super();
    }

    public Comedy(String title, int minutesLength, String genre, String filmDirector, double laughterVolume, int ageLimits) {
        super(title, minutesLength, genre, filmDirector);
        this.laughterVolume = laughterVolume;
        this.ageLimits = ageLimits;
    }

    /**
     * This method is used to select COMEDY actor for new film
     * @param actors    list of available actor
     * @param N         amount of actors required
     * @throws CastException    if required amount is bigger than possible
     */
    @Override
    public void castActors(List<Actor> actors, int N) throws CastException{
        Collections.shuffle(actors);
        int mnt=0;
        for (Actor actor : actors){
            if(actor.getFavouriteGenre() == CinemaGenres.COMEDY){
                this.actorSquad.add(actor);
                mnt++;
                if(mnt == N) break;
            }
        }
        if (mnt < N) throw new CastException("Unable to find so many actors for comedy film");
    }

    public double getLaughterVolume() {
        return laughterVolume;
    }

    public void setLaughterVolume(double laughterVolume) {
        this.laughterVolume = laughterVolume;
    }

    public int getAgeLimits() {
        return ageLimits;
    }

    public void setAgeLimits(int ageLimits) {
        this.ageLimits = ageLimits;
    }

    @Override
    public String toString() {
        return "Comedy film - '"+ title + "' {" +
                "\nlaughterVolume= " + laughterVolume +
                "\nageLimits= " + ageLimits +
                "\nlength= " + minutesLength + " mins" +
                "\ngenre= " + genre +
                "\nfilmDirector= " + filmDirector +
                "\nreleaseDate= " + releaseDate +
                "\nactorSquad: {\n" + showActorSquad() + "}" +
                '}';
    }
}
