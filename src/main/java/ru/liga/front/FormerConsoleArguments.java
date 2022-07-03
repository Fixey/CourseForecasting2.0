package ru.liga.front;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import ru.liga.exception.ArgumentsOptionFormatterException;

@Slf4j
public class FormerConsoleArguments {
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
            throw new ArgumentsOptionFormatterException();
        }
    }
}
