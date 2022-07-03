package ru.liga.front;

import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import org.junit.jupiter.api.Test;
import ru.liga.back.ExchangeRates;
import ru.liga.enums.CurrencyType;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class GraphBuilderTest {

    @Test
    void createGraph() throws PythonExecutionException, IOException {
        File file = new File(this.getClass()
                .getClassLoader().getResource("png/").getPath().substring(1) + "graph.png");
        file.delete();
        OutputGraph outputGraph = new OutputGraph();
        List<ExchangeRates> exchangeRatesList = new ArrayList<>();
        List<ExchangeRates> exchangeRatesList2 = new ArrayList<>();
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(10), LocalDate.now()));
        exchangeRatesList.add(new ExchangeRates(CurrencyType.USD, BigDecimal.valueOf(150), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(70), LocalDate.now()));
        exchangeRatesList2.add(new ExchangeRates(CurrencyType.EUR, BigDecimal.valueOf(200), LocalDate.now()));
        ArrayList myList = new ArrayList();
        myList.add(exchangeRatesList);
        myList.add(exchangeRatesList2);
        new GraphBuilder().createGraph(myList);
        this.getClass().getClassLoader().getResource("png/graph.png").getFile();
    }
}