package ru.liga.fat.front;

import ru.liga.fat.back.RatesPrediction;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param fullCommand полная команда
     * @return RatesPrediction списки курсов
     */
    RatesPrediction invoke(String fullCommand);
}