package ru.liga.fat.tech;

import ru.liga.fat.tech.entity.RatesPrediction;

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
