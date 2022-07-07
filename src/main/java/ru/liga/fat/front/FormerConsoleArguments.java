package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import ru.liga.fat.exception.ArgumentsOptionFormatterException;


/**
 * Формирование командной строки
 */
@Slf4j
public class FormerConsoleArguments {
    /**
     * @param fullCommand команда
     * @return команда в формате CommandLine
     * @throws ArgumentsOptionFormatterException при ошибке распарсивания команды
     */
    public CommandLine getCommandLineFromCommand(String fullCommand) {
        try {
            log.debug("Full Command in getCommandLineFromCommand = " + fullCommand);
            final String[] commandParts = fullCommand.split("\\s+");
            CommandOptions commandOptions = new CommandOptions();
            Options options = commandOptions.getCommandOptions();
            CommandLineParser parser = new DefaultParser();
            return parser.parse(options, commandParts);
        } catch (ParseException pe) {
            log.error(pe.getMessage());
            throw new ArgumentsOptionFormatterException(pe);
        }
    }
}
