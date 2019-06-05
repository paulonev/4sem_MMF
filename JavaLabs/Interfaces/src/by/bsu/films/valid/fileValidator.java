package by.bsu.films.valid;

import by.bsu.films.utils.CinemaGenres;
import by.bsu.films.utils.FileTags;

public class fileValidator {
    /**This method checks whether a string could represent an actor
     * If string contains NAME,SURNAME and GENRE
     * then it represents an object of ACTOR class
     * @param actor string from the file
     * @return true - if represents, false - otherwise
     */
    public static boolean isStringAnActor(String actor){
        return actor.contains(FileTags.NAME) && actor.contains(FileTags.SURNAME) && actor.contains(FileTags.GENRE);
    }

    /**Check if actorGenre from file matches any string representation of enum-parameter
     * @see CinemaGenres
     */
    public static boolean isValidGenre(String actorGenre){
        CinemaGenres[] allGenres = CinemaGenres.values(); //list of enum-parameters

        for (CinemaGenres genre : allGenres){
            if(genre.toString().equalsIgnoreCase(actorGenre))
                return true;
        }
        return false;
    }
}
