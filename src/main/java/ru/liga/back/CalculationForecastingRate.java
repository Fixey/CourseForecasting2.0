package ru.liga.back;

import ru.liga.util.AverageRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Рассчет прогнозирования курсов
 */
public class CalculationForecastingRate {
    /**
     * Рассчетать и вернуть спрогнозированных курсов по алгоритму "среднему за n дней"
     *
     * @param listExchangeRatesIn Список объектов за n дней до текущего дня
     * @param days                Кол-во дней на сколько спрогнозировать
     * @param currency            Валюта
     * @return LinkedList<ExchangeRates> Список спрогнозированных объектов Курсов Валют
     */
    public LinkedList<ExchangeRates> getListOfForecastingExchangeRates(LinkedList<ExchangeRates> listExchangeRatesIn, Integer days, String currency) {
        LinkedList<ExchangeRates> listExchangeRatesForCalc = (LinkedList<ExchangeRates>) listExchangeRatesIn.clone();
        LinkedList<ExchangeRates> listExchangeRates = new LinkedList<>();
        BigDecimal rate;
        AverageRate averageRate = new AverageRate();
        if (days == 0) {
            rate = averageRate.getAverageRateForExchangeRates(listExchangeRatesForCalc);
            listExchangeRates.add(new ExchangeRates(currency, rate, LocalDate.now()));
            return listExchangeRates;

        }
        for (int i = 1; i <= days; i++) {
            rate = averageRate.getAverageRateForExchangeRates(listExchangeRatesForCalc);
            ExchangeRates exchangeRates = new ExchangeRates(currency, rate, LocalDate.now().plusDays(i));
            listExchangeRatesForCalc.pollLast();
            listExchangeRatesForCalc.offerFirst(exchangeRates);
            listExchangeRates.add(exchangeRates);

        }
        return listExchangeRates;
    }
}
