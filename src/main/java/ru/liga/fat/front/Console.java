package ru.liga.fat.front;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.ExchangeRates;

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
     * @return List<List<ExchangeRates>> результат выполнения команды
     */
    public List<List<ExchangeRates>> invokeCommand() {
        Command command = new CommandSelector().getCommand(commandName);
        log.debug("Console = " + command.getClass().getName());
        log.info("CommandName = " + commandName);
        return command.invoke(fullCommand);
    }

}
