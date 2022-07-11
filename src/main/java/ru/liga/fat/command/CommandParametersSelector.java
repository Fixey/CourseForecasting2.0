package ru.liga.fat.command;

import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.entity.RateParameters;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.command.exception.ConsoleArgsException;

/**
 * Выбор распарсивателя в зависимости от команды
 */
public class CommandParametersSelector {
    /**
     * Переводит из String в CommandParameters
     *
     * @param fullCommand комманда
     * @return CommandParameters параметры команды
     */
    public CommandParameters chooseCommand(String fullCommand) {
        String sCommand = fullCommand.split("\\s+")[0];
        CommandsType command = EnumUtils.getEnumIgnoreCase(CommandsType.class, sCommand);
        if (command == null) {
            throw new ConsoleArgsException();
        }
        switch (command) {
            case rate:
                return new RateParameters(fullCommand);
            case help:
                return new HelpParameters(fullCommand);
        }
        throw new ConsoleArgsException();
    }
}
