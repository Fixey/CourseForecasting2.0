package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.ExchangeRates;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.SendMessageException;

import java.util.stream.Collectors;

@Slf4j
public class OutputList implements IOutputRateCommander {
    /**
     * Обработка output
     * Распечатывание результата
     *
     * @param ratesPrediction списки курсов
     * @param chatId          Id чата
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @Override
    public SendingMessage getMessage(RatesPrediction ratesPrediction, String chatId) {
        log.debug("OutputList args:");
        log.debug("listExchangeRates =" + ratesPrediction.getListExchangeRates());
        log.debug("chatId =" + chatId);
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
