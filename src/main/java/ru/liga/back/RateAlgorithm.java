package ru.liga.back;

import java.util.List;

/**
 * Алгоритм
 */
public interface RateAlgorithm {
    /**
     * Выполнение алгоритма и вывод результата
     *
     * @param currency тип валюты
     * @param day      кол-во дней на сколько надо предсказать курса
     * @return List Результат выполнения алгоритма
     */
    List getListResult(String currency, int day);
}
