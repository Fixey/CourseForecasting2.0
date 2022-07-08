package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CommandsType;

/**
 * Выбор какой Output вызывать
 */
@Slf4j
public class OutputSelector {
    public SendingMessage getMessage(CommandParameters commandParameters, RatesPrediction ratesPrediction) {
        SendingMessage sendingMessage = new SendingMessage();
        if (commandParameters.getCommand().equals(CommandsType.help)) {
            sendingMessage.addMessage(new OutputHelp().getHelpMessage());
        } else {
            IOutputRateCommander outputRateCommander = new OutputRateSelector().getOutput(commandParameters);
            sendingMessage = outputRateCommander.getMessage(ratesPrediction);
            log.debug("outputRateCommander = " + outputRateCommander.getClass().getName());
        }
        return sendingMessage;
    }
}
