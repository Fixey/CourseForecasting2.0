package ru.liga.fat.command;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.command.exception.UnknownCommandException;

/**
 * Выбор команды
 */
@Slf4j
public class CommandSelector {
    /**
     * Вернуть объект Command
     *
     * @param command название команды
     * @return Возвращает объект Command
     */
    public Command getCommand(CommandsType command) {
        switch (command) {
            case help:
                return new CommandHelp();
            case rate:
                return new CommandRate();
            default:
                throw new UnknownCommandException();
        }
    }
}
