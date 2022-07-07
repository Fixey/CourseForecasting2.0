package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.exception.ConsoleException;

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
            CommandsType commandName = (CommandsType) commandParameters.getParameters().get("command");
            Command command = new CommandSelector().getCommand(commandName);
            return command.invoke(commandParameters);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ConsoleException(e);
        }
    }
}
