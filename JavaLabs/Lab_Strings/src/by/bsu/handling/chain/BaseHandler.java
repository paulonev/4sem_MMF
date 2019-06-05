package by.bsu.handling.chain;

import by.bsu.handling.composite.Component;

public interface BaseHandler {
    Component handleText(String text);
}
