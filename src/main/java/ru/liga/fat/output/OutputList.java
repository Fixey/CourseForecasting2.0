package ru.liga.fat.output;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.entity.ExchangeRates;
import ru.liga.fat.entity.RatesPrediction;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.sending.SendingMessage;
import ru.liga.fat.sending.exception.SendMessageException;

import java.util.stream.Collectors;

@Slf4j
public class OutputList implements IOutputRateCommander {
    /**
     * Обработка output
     * Распечатывание результата
     *
     * @param ratesPrediction списки курсов
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @Override
    public SendingMessage getMessage(RatesPrediction ratesPrediction) {
        log.debug("OutputList args:");
        log.debug("listExchangeRates =" + ratesPrediction.getListExchangeRates());
        SendingMessage sendingMessage = new SendingMessage();
        for (CurrencyType currency : ratesPrediction.getCurrencies()) {
            String messageText = currency.name() + ":\n";
            messageText += ratesPrediction.getExchangeRatesByCurrency(currency)
                    .stream()
                    .map(ExchangeRates::getInfo)
                    .collect(Collectors.joining("\n"));
            sendingMessage.addMessage(messageText);
        }
        return sendingMessage;
    }
}
