package ru.liga.back;


import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PlotImpl;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import com.github.sh0nk.matplotlib4j.builder.PlotBuilder;
import org.junit.jupiter.api.Test;
import ru.liga.enums.CurrencyType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmMistForecastingTest {

    @Test
    void getListExchangeRatesTest() {
        new Configurations();
        AlgorithmMistForecasting algorithmMistForecasting = new AlgorithmMistForecasting();
        List<ExchangeRates> exchangeRatesList = algorithmMistForecasting.getListExchangeRates(CurrencyType.USD,
                LocalDate.now().plusDays(10));
        assertEquals(exchangeRatesList.size(),1);
        System.out.println(exchangeRatesList);
    }

    @Test
    void testGetListExchangeRatesTest2() {
        new Configurations();
        AlgorithmMistForecasting algorithmMistForecasting = new AlgorithmMistForecasting();
        List<ExchangeRates> exchangeRatesList = algorithmMistForecasting.getListExchangeRates(CurrencyType.USD, 10);
        assertEquals(exchangeRatesList.size(),10);
        exchangeRatesList.stream().sorted(Comparator.comparing(ExchangeRates::getDate).reversed()).forEach(System.out::println);

    }

}