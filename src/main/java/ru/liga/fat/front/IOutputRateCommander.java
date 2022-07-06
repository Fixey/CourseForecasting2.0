package ru.liga.fat.front;

import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.telegram.Bot;

/**
 * Обработчик output
 */
public interface IOutputRateCommander {
    /**
     * Отправка и обработка сообщения
     *
     * @param ratesPrediction список ставок который надо обработать
     * @param chatId          Id чата для отправки сообщения
     * @param bot             Бот
     */
    void sendToOut(RatesPrediction ratesPrediction, String chatId, Bot bot);
}
