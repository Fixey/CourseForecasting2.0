package ru.liga.fat.tech;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.tech.enums.CommandsType;
import ru.liga.fat.tech.exception.ConsoleException;
import ru.liga.fat.tech.entity.RatesPrediction;

/**
 * Оболочка для вызова команды
 */
@Slf4j
public class CommandHandler {
    /**
     * @param commandParameters параметры команды
     * @return RatesPrediction результат команды
     * @throws ConsoleException ошибка если что-то случилось при выполнении команды
     */
    public RatesPrediction invokeCommandFromConsole(CommandParameters commandParameters) {
        try {
            log.debug("Start");
            CommandsType commandName = commandParameters.getCommand();
            Command command = new CommandSelector().getCommand(commandName);
            return command.invoke(commandParameters);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ConsoleException(e);
        }
    }
}
