package by.bsu.films.parse;

import by.bsu.films.utils.CinemaGenres;
import by.bsu.films.utils.FileTags;
import by.bsu.films.exception.WrongDataException;
import by.bsu.films.valid.fileValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ActorParser {
    private String fileLine; //строка текста из файла
    private static Pattern p = Pattern.compile(" |="); //формат, по которому разбивается строка

    public ActorParser(String fileLine) {
        this.fileLine = fileLine.toUpperCase();
    }

    public String getFileLine() {
        return fileLine;
    }

    /**This method takes actor's NAME parameter from file and creates String value of it
     *
     * @return  actor's name
     * @throws WrongDataException if file's string doesn't represent an actor
     */
    public String takeActorName() throws WrongDataException{
        if(fileValidator.isStringAnActor(this.fileLine)) {
            int index = fileLine.indexOf(FileTags.NAME) + FileTags.NAME.length();
            Scanner sc = new Scanner(fileLine.substring(index)); // установить сканер на начало данных
            sc.useDelimiter(p); // разбивание данных, которые будут считываться потоком по шаблону
            return sc.next();
        } else throw new WrongDataException("String doesn't represent an actor, please check resource file. //takeActorName");
    }

    /**This method takes actor's SURNAME parameter from file and creates String value of it
     *
     * @return  actor's surname
     * @throws WrongDataException if file's string doesn't represent an actor
     */
    public String takeActorSurname() throws WrongDataException{
        if(fileValidator.isStringAnActor(this.fileLine)) {
            int index = fileLine.indexOf(FileTags.SURNAME) + FileTags.SURNAME.length();
            Scanner sc = new Scanner(fileLine.substring(index)); // установить сканер на начало данных
            sc.useDelimiter(p); // разбивание данных, которые будут считываться потоком по шаблону
            return sc.next();
        } else throw new WrongDataException("String doesn't represent an actor, please check resource file. //takeActorSurname");
    }

    /**This method takes actor's GENRE parameter from file and creates enum-parameter of it
     *
     * @return  actor's enum genre
     * @throws WrongDataException if file's string doesn't represent an actor or there is no such a genre in CinemaGenres class
     * @see by.bsu.films.utils.CinemaGenres
     */
    public CinemaGenres takeActorGenre() throws WrongDataException{
        if(fileValidator.isStringAnActor(this.fileLine)) {
            int index = fileLine.indexOf(FileTags.GENRE) + FileTags.GENRE.length();
            Scanner sc = new Scanner(fileLine.substring(index)); // установить сканер на начало данных
            sc.useDelimiter(p); // разбивание данных, которые будут считываться потоком по шаблону
            String genre = sc.next();
            if(fileValidator.isValidGenre(genre)){
                return CinemaGenres.valueOf(genre);
            } else throw new WrongDataException("Genre parameter from file doesn't match any real from CinemaGenres");
        } else throw new WrongDataException("String doesn't represent an actor, please check resource file. //takeActorGenre");
    }
}
