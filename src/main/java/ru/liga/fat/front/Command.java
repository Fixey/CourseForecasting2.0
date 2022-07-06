package ru.liga.fat.front;

import ru.liga.fat.back.ExchangeRates;
import ru.liga.fat.back.RatesPrediction;

import java.util.List;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param fullCommand полная команда
     * @return List<List<ExchangeRates>> списки курсов
     */
    RatesPrediction invoke(String fullCommand);
}