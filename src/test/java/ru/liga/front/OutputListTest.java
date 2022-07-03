package ru.liga.front;

import org.junit.jupiter.api.Test;
import ru.liga.back.ExchangeRates;
import ru.liga.enums.CurrencyType;
import ru.liga.exception.SendMessageException;
import ru.liga.telegram.Bot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputListTest {

    @Test
    void getListsExchangeRatesException() {
        List<ExchangeRates> exchangeRatesList = new ArrayList<>();
        List<ExchangeRates> exchangeRatesList2 = new ArrayList<>();
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(10), LocalDate.now()));
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(150), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(70), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(200), LocalDate.now()));
        ArrayList listsExchangeRates = new ArrayList();
        listsExchangeRates.add(exchangeRatesList);
        listsExchangeRates.add(exchangeRatesList2);
        OutputList outputList = new OutputList();
        assertThrows(SendMessageException.class, () -> {
            outputList.sendToOut(listsExchangeRates, "3f", new Bot());
        });
    }
}