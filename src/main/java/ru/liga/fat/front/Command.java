package ru.liga.fat.front;

import ru.liga.fat.back.RatesPrediction;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param commandParameters параметры команды
     * @return RatesPrediction списки курсов
     */
    RatesPrediction invoke(CommandParameters commandParameters);
}