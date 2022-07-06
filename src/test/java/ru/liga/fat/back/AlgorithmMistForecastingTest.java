package ru.liga.fat.back;


import org.junit.jupiter.api.Test;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmMistForecastingTest {


    @Test
    void getListExchangeRatesWithDays() {
        AlgorithmMistForecasting algorithmMistForecasting = new AlgorithmMistForecasting(getDefaultData());
        List<ExchangeRates> exchangeRatesList = algorithmMistForecasting.getListExchangeRates(CurrencyType.USD,
                LocalDate.now().plusDays(10));
        assertEquals(exchangeRatesList.size(), 1);
    }

    @Test
    void testGetListExchangeRatesWithPeriod() {
        AlgorithmMistForecasting algorithmMistForecasting = new AlgorithmMistForecasting(getDefaultData());
        List<ExchangeRates> exchangeRatesList = algorithmMistForecasting.getListExchangeRates(CurrencyType.USD, 10);
        assertEquals(exchangeRatesList.size(), 10);
    }

    private LinkedList<ExchangeRates> getDefaultData() {
        LinkedList<ExchangeRates> exchangeRates = new LinkedList<>();
        int counter_day = 0;
        for (int i = 10; i < 1000; i = i + 100) {
            exchangeRates.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(i), LocalDate.now().plusDays(counter_day).minusYears(1)));
            exchangeRates.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(i), LocalDate.now().plusDays(counter_day).minusYears(1)));
            counter_day++;
        }
        return exchangeRates;
    }
}