package ru.liga.front;

import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import org.junit.jupiter.api.Test;
import ru.liga.back.ExchangeRates;
import ru.liga.enums.CurrencyType;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

class GraphBuilderTest {

    @Test
    void createGraph() throws PythonExecutionException, IOException {
        File file = new File(this.getClass()
                .getClassLoader().getResource("").getPath().substring(1) + "graph.png");
        file.delete();
        new GraphBuilder().createGraph(getDefaultData());
        this.getClass().getClassLoader().getResource("graph.png");
    }

    private List<List<ExchangeRates>> getDefaultData() {
        List<ExchangeRates> exchangeRatesList = new LinkedList<>();
        List<ExchangeRates> exchangeRatesList2 = new LinkedList<>();
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(10), LocalDate.now()));
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(150), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(70), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(200), LocalDate.now()));
        List<List<ExchangeRates>> listResult = new LinkedList<>();
        listResult.add(exchangeRatesList);
        listResult.add(exchangeRatesList2);
        return listResult;
    }
}