package ru.liga.fat.front;

import org.junit.jupiter.api.Test;
import ru.liga.fat.back.AlgorithmSelector;
import ru.liga.fat.back.ExchangeRates;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandRateTest {

    @Test
    void getListExchangeRatesFromCommandRate() {
        LinkedList<ExchangeRates> exchangeRates = getDefaultData();
        CommandRate commandRate = new CommandRate(new AlgorithmSelector(exchangeRates));
        RatesPrediction ratesPrediction = commandRate.invoke("rate usd,eur -period week -alg mist -output list");
        assertEquals(ratesPrediction.currencies.size(), 2);
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