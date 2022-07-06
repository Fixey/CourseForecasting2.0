package ru.liga.fat.front;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.RatesPrediction;

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
     *
     * @return RatesPrediction результат выполнения команды
     */
    public RatesPrediction invokeCommand() {
        Command command = new CommandSelector().getCommand(commandName);
        log.debug("Console = " + command.getClass().getName());
        log.info("CommandName = " + commandName);
        return command.invoke(fullCommand);
    }

}
