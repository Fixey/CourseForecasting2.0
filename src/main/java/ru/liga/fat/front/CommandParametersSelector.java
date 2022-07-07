package ru.liga.fat.front;

import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.exception.ConsoleArgsException;

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
        switch (command) {
            case rate:
                return new RateParameters();
            case help:
                return new HelpParameters();
        }
        throw new ConsoleArgsException();
    }
}
