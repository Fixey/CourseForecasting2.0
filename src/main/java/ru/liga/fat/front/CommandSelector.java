package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.exception.UnknownCommandException;

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
    public Command getCommand(String command) {
        switch (command.toLowerCase()) {
            case ("help"):
                return new CommandHelp();
            case ("rate"):
                return new CommandRate();
            default:
                throw new UnknownCommandException();
        }
    }
}
