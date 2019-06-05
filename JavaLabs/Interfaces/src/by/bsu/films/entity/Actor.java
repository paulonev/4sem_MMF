package by.bsu.films.entity;

import by.bsu.films.utils.CinemaGenres;

/**
 * Entity that represents domestic actors
 * They are given NAME, SURNAME, GENRE of films where they usually appear
 */
public class Actor {
    private String name;
    private String surname;
    private CinemaGenres favouriteGenre; //жанр, на котором актёр специализируется

    public Actor(String name, String surname, CinemaGenres favouriteGenre) {
        this.name = name;
        this.surname = surname;
        this.favouriteGenre = favouriteGenre;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public CinemaGenres getFavouriteGenre() {
        return favouriteGenre;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }
}
