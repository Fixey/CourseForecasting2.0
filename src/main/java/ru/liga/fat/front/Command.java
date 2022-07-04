package ru.liga.fat.front;

import ru.liga.fat.back.ExchangeRates;

import java.util.List;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param fullCommand полная команда
     * @return List<List<ExchangeRates>> списки курсов
     */
    List<List<ExchangeRates>> invoke(String fullCommand);
}