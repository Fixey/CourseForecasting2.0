package ru.liga.front;

import ru.liga.exception.UnknownCommandException;

/**
 * Выбор команды
 */
public class CommandSelector {
    /**
     * Вернуть объект Command
     *
     * @param command название команды
     * @return Возвращает объект Command
     */
    public Command getCommand(String command) {
        switch (command) {
            case ("help"):
                return new CommandHelp();
            case ("rate"):
                return new CommandRate();
            default:
                throw new UnknownCommandException();
        }
    }
}
