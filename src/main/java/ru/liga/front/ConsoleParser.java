package ru.liga.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.exception.ConsoleArgsException;

@Slf4j
public class ConsoleParser {
    /**
     * Распарсивает команду с консоли
     *
     * @param args команда
     * @return объект типа Console
     * @throws ConsoleArgsException падает при ошибке с аругментами заданные в консоле
     */
    public Console consoleParser(String args) {
        try {
            final String[] arrParams = args.trim().split("\\s+");
            final String command = arrParams[0].toLowerCase();
            return new Console(command, args);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            log.error(e.getMessage());
            throw new ConsoleArgsException();
        }
    }
}

