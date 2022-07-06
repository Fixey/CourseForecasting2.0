package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.fat.back.ExchangeRates;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.SendMessageException;
import ru.liga.fat.telegram.Bot;

import java.util.stream.Collectors;

@Slf4j
public class OutputList implements IOutputRateCommander {
    /**
     * Обработка output
     * Распечатывание результата
     *
     * @param ratesPrediction списки курсов
     * @param chatId          Id чата
     * @param bot             инстанс бота
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @Override
    public void sendToOut(RatesPrediction ratesPrediction, String chatId, Bot bot) {
        log.debug("OutputList args:");
        log.debug("listExchangeRates =" + ratesPrediction.getListExchangeRates());
        log.debug("chatId =" + chatId);
        for (CurrencyType currency : ratesPrediction.getCurrencies()) {
            try {
                String messageText = currency.name() + ":\n";
                messageText += ratesPrediction.getExchangeRatesByCurrency(currency)
                        .stream()
                        .map(ExchangeRates::getInfo)
                        .collect(Collectors.joining("\n"));
                SendMessage sendMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text(messageText)
                        .build();
                bot.execute(sendMessage);
                log.info("Send list to client");
            } catch (TelegramApiException e) {
                log.error(e.getMessage(), e);
                throw new SendMessageException();
            }
        }
    }
}
