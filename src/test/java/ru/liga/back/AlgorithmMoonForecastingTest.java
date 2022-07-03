package ru.liga.back;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.liga.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmMoonForecastingTest {
@BeforeEach
void set_up(){
    new Configurations();
}
    @Test
    void getListResultPeriod() {
        AlgorithmMoonForecasting algorithmMoonForecasting = new AlgorithmMoonForecasting();
        LinkedList<ExchangeRates> exchangeRates = algorithmMoonForecasting.getListExchangeRates(CurrencyType.USD,7);
        assertEquals(exchangeRates.size(),7);
        assertEquals(exchangeRates.get(0).getRate(),BigDecimal.valueOf(72.3723));
        assertEquals(exchangeRates.get(1).getRate(),BigDecimal.valueOf(72.7234));
    }

    @Test
    void testGetListResult() {
//        new Configurations();
//        AlgorithmMoonForecasting algorithmMoonForecasting = new AlgorithmMoonForecasting();
//        LinkedList<ExchangeRates> exchangeRates = algorithmMoonForecasting.getListExchangeRates(CurrencyType.USD,LocalDate.now().plusDays(1));
//        assertEquals(exchangeRates.get(0).getRate(),BigDecimal.valueOf(72.7234));

    }
}