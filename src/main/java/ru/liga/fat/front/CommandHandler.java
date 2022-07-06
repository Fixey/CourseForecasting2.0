package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.exception.ConsoleException;

/**
 * Оболочка для консоли бота
 */
@Slf4j
public class CommandHandler {
    /**
     * @param command комманда
     * @return RatesPrediction результат команды
     * @throws ConsoleException ошибка если что-то случилось при выполнении команды
     */
    public RatesPrediction invokeCommandFromConsole(String command) {
        try {
            log.debug("Start");
            ConsoleParser consoleParser = new ConsoleParser();
            Console console = consoleParser.consoleParser(command);
            log.debug("Console=" + console.getCommandName().name());
            log.debug("Console Command=" + console.getFullCommand());
            return console.invokeCommand();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ConsoleException(e);
        }
    }
}
