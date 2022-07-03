package ru.liga.front;

import ru.liga.back.ExchangeRates;
import ru.liga.telegram.Bot;

import java.util.List;

/**
 * Обработчик output
 */
public interface IOutputRateCommander {
    /**
     * Отправка и обработка сообщения
     *
     * @param listExchangeRates список ставок который надо обработать
     * @param chatId            Id чата для отправки сообщения
     * @param bot               Бот
     */
    void sendToOut(List<List<ExchangeRates>> listExchangeRates, String chatId, Bot bot);
}
