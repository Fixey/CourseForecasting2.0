package ru.liga.front;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.back.ExchangeRates;
import ru.liga.exception.SendMessageException;
import ru.liga.telegram.Bot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class OutputList implements IOutputRateCommander {
    /**
     * Обработка output
     * Распечатывание результата
     *
     * @param listsExchangeRates списки курсов
     * @param chatId             Id чата
     * @param bot                инстанс бота
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @Override
    public void sendToOut(List<List<ExchangeRates>> listsExchangeRates, String chatId, Bot bot) {
        log.debug("OutputList args:");
        log.debug("listsExchangeRates =" + listsExchangeRates.toString());
        log.debug("chatId =" + chatId);
        for (List<ExchangeRates> listExchangeRates : listsExchangeRates) {
            String messageText = listExchangeRates.stream().findFirst().get().getCurrency().toString() + "\n";
            messageText += listExchangeRates.stream()
                    .sorted(Comparator.comparing(ExchangeRates::getCurrency).thenComparing(ExchangeRates::getDate).reversed())
                    .map(ExchangeRates::getInfo).collect(Collectors.joining("\n"));
            SendMessage sendMessage = SendMessage.builder()
                    .chatId(chatId)
                    .text(messageText)
                    .build();
            try {
                bot.execute(sendMessage);
                log.info("Send list to client");

            } catch (TelegramApiException e) {
                log.error(e.getMessage());
                throw new SendMessageException();
            }
        }
    }
}
