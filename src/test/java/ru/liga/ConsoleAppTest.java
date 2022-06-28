package ru.liga;

import org.junit.Test;
import ru.liga.front.ConsoleParser;

public class ConsoleAppTest {
    @Test
    public void getConsoleEngineWithoutExceptions() {
        ConsoleParser consoleParser = new ConsoleParser();
        consoleParser.consoleParser("rate usd today");
        consoleParser.consoleParser("rate usd week");
        consoleParser.consoleParser("rate usd week wtf");
    }
}
