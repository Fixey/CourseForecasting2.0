package ru.liga.front;

import lombok.NonNull;
import ru.liga.exception.ConsoleArgsException;

import java.util.Arrays;
import java.util.LinkedList;

public class ConsoleParser {
    /**
     * Распарсивает команду с консоли
     *
     * @param args команда
     * @return объект типа Console
     * @throws ConsoleArgsException падает при ошибке с аругментами заданные в консоле
     */
    public Console consoleParser(@NonNull String args) {
        try {
            String[] arrParams = args.trim().split("\\s+");
            String command = arrParams[0].toLowerCase();
            LinkedList<String> commandArgs = new LinkedList<>
                    (Arrays.asList(arrParams).subList(1, arrParams.length));
            return new Console(command, commandArgs);
        } catch (IndexOutOfBoundsException e) {
            throw new ConsoleArgsException();
        }
    }
}
