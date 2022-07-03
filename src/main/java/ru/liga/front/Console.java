package ru.liga.front;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Объект консоль
 */
@Data
@AllArgsConstructor
@Slf4j
public class Console {

    public String commandName;
    public String fullCommand;

    /**
     * Обработка команды
     */
    public List invokeCommand() {
        Command command = new CommandSelector().getCommand(commandName);
        log.debug("Console = " + command.getClass().getName());
        log.info("CommandName = " + commandName);
        return command.invoke(fullCommand);
    }

}
