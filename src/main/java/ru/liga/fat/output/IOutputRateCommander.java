package ru.liga.fat.output;

import ru.liga.fat.entity.RatesPrediction;
import ru.liga.fat.sending.SendingMessage;

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
