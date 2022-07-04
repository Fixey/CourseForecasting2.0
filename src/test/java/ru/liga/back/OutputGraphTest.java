package ru.liga.back;

import org.junit.jupiter.api.Test;
import ru.liga.enums.CurrencyType;
import ru.liga.exception.SendMessageException;
import ru.liga.front.OutputGraph;
import ru.liga.telegram.Bot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputGraphTest {

    @Test
    void getSendMessageException() {
        OutputGraph outputGraph = new OutputGraph();
        assertThrows(SendMessageException.class, () -> {
            outputGraph.sendToOut(Collections.singletonList(getDefaultData()), "3f", new Bot());
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