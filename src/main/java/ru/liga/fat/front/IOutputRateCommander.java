package ru.liga.fat.front;

import ru.liga.fat.back.RatesPrediction;

/**
 * Обработчик output для команды Rate
 */
public interface IOutputRateCommander {
    /**
     * Формирование сообщения, которое надо отправить
     *
     * @param ratesPrediction список ставок который надо обработать
     * @return Object результат который надо вывести
     */
    SendingMessage getMessage(RatesPrediction ratesPrediction);
}
