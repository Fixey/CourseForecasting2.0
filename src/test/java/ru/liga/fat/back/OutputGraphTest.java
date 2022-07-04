package ru.liga.fat.back;

import org.junit.jupiter.api.Test;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.SendMessageException;
import ru.liga.fat.front.OutputGraph;
import ru.liga.fat.telegram.Bot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputGraphTest {

    @Test
    void getSendMessageException() {
        OutputGraph outputGraph = new OutputGraph();
        String botToken = System.getenv("BOT_FORECASTING_TOKEN");
        String botName = System.getenv("BOT_FORECASTING_NAME");
        assertThrows(SendMessageException.class, () -> {
            outputGraph.sendToOut(Collections.singletonList(getDefaultData()), "3f", new Bot(botToken,botName));
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