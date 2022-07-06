package ru.liga.fat.front;

import ru.liga.fat.back.RatesPrediction;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param fullCommand полная команда
     * @return List<List < ExchangeRates>> списки курсов
     */
    RatesPrediction invoke(String fullCommand);
}