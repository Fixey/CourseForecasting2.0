package ru.liga.fat.command;

import ru.liga.fat.entity.RatesPrediction;

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