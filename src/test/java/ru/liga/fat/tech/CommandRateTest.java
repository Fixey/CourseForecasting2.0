package ru.liga.fat.tech;

import ru.liga.fat.tech.entity.RatesPrediction;
import ru.liga.fat.tech.enums.CurrencyType;
import ru.liga.fat.tech.entity.ExchangeRates;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

class CommandRateTest {

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

    static class OutputGraphTest {

        private RatesPrediction getDefaultData() {
            LinkedList<ExchangeRates> exchangeRates = new LinkedList<>();
            int counter_day = 0;
            for (int i = 10; i < 1000; i = i + 100) {
                exchangeRates.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(i), LocalDate.now().plusDays(counter_day).minusYears(1)));
                exchangeRates.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(i), LocalDate.now().plusDays(counter_day).minusYears(1)));
                counter_day++;
            }
            RatesPrediction ratesPrediction = new RatesPrediction();
            ratesPrediction.addListExchangeRates(exchangeRates);
            return ratesPrediction;
        }
    }
}