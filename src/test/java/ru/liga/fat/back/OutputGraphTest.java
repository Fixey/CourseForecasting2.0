package ru.liga.fat.back;

import org.junit.jupiter.api.Test;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.SendMessageException;
import ru.liga.fat.front.OutputGraph;
import ru.liga.fat.telegram.Bot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputGraphTest {

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