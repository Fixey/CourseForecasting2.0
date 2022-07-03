package ru.liga.back;

import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.liga.enums.CurrencyType;
import ru.liga.front.GraphBuilder;
import ru.liga.front.OutputGraph;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class OutputGraphTest {
    @SneakyThrows
    @Test
    void createGraph() {
        OutputGraph outputGraph = new OutputGraph();
        List<ExchangeRates> exchangeRatesList= new ArrayList<>();
        List<ExchangeRates> exchangeRatesList2= new ArrayList<>();
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD,BigDecimal.valueOf(10), LocalDate.now()));
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD,BigDecimal.valueOf(150), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR,BigDecimal.valueOf(70), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR,BigDecimal.valueOf(200), LocalDate.now()));
        List<List<ExchangeRates>> myList = new ArrayList();
        myList.add(exchangeRatesList);
        myList.add(exchangeRatesList2);
        new GraphBuilder().createGraph(myList);

    }

    @Test
    void sendToOut() {
    }
}