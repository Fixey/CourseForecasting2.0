package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.exception.ConsoleArgsException;

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
            final CommandsType command = EnumUtils.getEnumIgnoreCase(CommandsType.class,arrParams[0].toLowerCase());
            return new Console(command, args);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            log.error(e.getMessage(), e);
            throw new ConsoleArgsException();
        }
    }
}

