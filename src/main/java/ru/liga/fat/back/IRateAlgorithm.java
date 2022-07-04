package ru.liga.fat.back;

import ru.liga.fat.enums.CurrencyType;

import java.time.LocalDate;
import java.util.List;

/**
 * Алгоритм
 */
public interface IRateAlgorithm {
    /**
     * Выполнение алгоритма и вывод результата
     *
     * @param currency тип валюты
     * @param period   кол-во дней на сколько надо предсказать курса
     * @return List Результат выполнения алгоритма
     */

    List<ExchangeRates> getListExchangeRates(CurrencyType currency, Integer period);

    /**
     * Выполнение алгоритма и вывод результата
     *
     * @param currency тип валюты
     * @param date     дата на который надо предсказать
     * @return List Результат выполнения алгоритма
     */
    List<ExchangeRates> getListExchangeRates(CurrencyType currency, LocalDate date);

}
