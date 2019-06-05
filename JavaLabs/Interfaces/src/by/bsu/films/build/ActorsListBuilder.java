package by.bsu.films.build;

import by.bsu.films.entity.Actor;
import by.bsu.films.exception.WrongDataException;
import by.bsu.films.parse.ActorParser;
import by.bsu.films.read.ActorReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ActorsListBuilder {
    public static List<Actor> initializeActorsList(String filePath) throws FileNotFoundException, WrongDataException {
        List<Actor> actors = new ArrayList<>();
        ActorBuilder builder = new ActorBuilder();
        ArrayList<String> stringsFromFile = ActorReader.readFile(filePath);
        for(String str : stringsFromFile){
            ActorParser parser = new ActorParser(str);
            builder.setParser(parser);
            actors.add(builder.createActor());
        }
        return actors;
    }
}
