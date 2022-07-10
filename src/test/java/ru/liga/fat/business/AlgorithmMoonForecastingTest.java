package ru.liga.fat.business;

import org.junit.jupiter.api.Test;
import ru.liga.fat.tech.enums.CurrencyType;
import ru.liga.fat.tech.entity.ExchangeRates;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmMoonForecastingTest {

    @Test
    void testGetListExchangeRatesPeriod() {
        AlgorithmMoonForecasting algorithmMoonForecasting = new AlgorithmMoonForecasting(getDefaultData());
        List<ExchangeRates> exchangeRates = algorithmMoonForecasting.getListExchangeRates(CurrencyType.USD, 7);
        assertEquals(exchangeRates.size(), 7);

    }

    @Test
    void testGetListExchangeRatesDay() {
        AlgorithmMoonForecasting algorithmMoonForecasting = new AlgorithmMoonForecasting(getDefaultData());
        List<ExchangeRates> exchangeRates = algorithmMoonForecasting.getListExchangeRates(CurrencyType.USD, LocalDate.now().plusDays(7));
        assertEquals(exchangeRates.size(), 1);
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