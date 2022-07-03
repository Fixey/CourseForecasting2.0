package ru.liga.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.exception.ConsoleException;

import java.util.List;

/**
 * Оболочка для консоли бота
 */
@Slf4j
public class CommandHandler {
    public List consoleEngine(String command) {
        try {
            log.debug("Start " + Thread.currentThread().getStackTrace()[1].getMethodName());
            ConsoleParser consoleParser = new ConsoleParser();
            Console console = consoleParser.consoleParser(command);
            log.debug("Console=" + console.getCommandName());
            log.debug("Console Command=" + console.getFullCommand());
            return console.invokeCommand();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ConsoleException(e);
        }
    }
}
