package ru.liga.front;

import org.junit.jupiter.api.Test;
import ru.liga.back.ExchangeRates;
import ru.liga.enums.CurrencyType;
import ru.liga.exception.SendMessageException;
import ru.liga.telegram.Bot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputListTest {

    @Test
    void getSendMessageException() {
        OutputList outputList = new OutputList();
        assertThrows(SendMessageException.class, () -> {
            outputList.sendToOut(Collections.singletonList(getDefaultData()), "3f", new Bot());
        });
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