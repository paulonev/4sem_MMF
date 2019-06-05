package by.bsu.films.build;

import by.bsu.films.entity.Actor;
import by.bsu.films.exception.WrongDataException;
import by.bsu.films.parse.ActorParser;

public class ActorBuilder {
    private ActorParser parser;

    public ActorBuilder(){}

    public ActorBuilder(ActorParser parser) {
        this.parser = parser;
    }

    public void setParser(ActorParser parser) {
        this.parser = parser;
    }

    public Actor createActor() throws WrongDataException {
        return new Actor(parser.takeActorName(),parser.takeActorSurname(),parser.takeActorGenre());
    }
}
