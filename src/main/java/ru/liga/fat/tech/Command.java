package ru.liga.fat.tech;

import ru.liga.fat.tech.entity.RatesPrediction;

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