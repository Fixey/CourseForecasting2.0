package ru.liga.fat.front;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.ExchangeRates;
import ru.liga.fat.exception.CreateGraphException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static ru.liga.fat.constant.ConstantUtil.COLOR_DICT;

/**
 * Создание графиков
 */
@Slf4j
public class GraphBuilder {
    /**
     * Создает график
     * @param listsExchangeRates списки курсов для разных валют
     * @throws CreateGraphException падает при не успехе создания графика
     */
    public void createGraph(List<List<ExchangeRates>> listsExchangeRates) {
        try {
            log.debug("Invoke GraphBuilder.createGraph()");
            log.debug("listsExchangeRates = " + listsExchangeRates.toString());
            Plot plot = Plot.create();
            int color_counter = 0;
            for (List<ExchangeRates> listExchangeRates : listsExchangeRates) {
                List<BigDecimal> rate = listExchangeRates
                        .stream()
                        .map(ExchangeRates::getRate)
                        .collect(Collectors.toList());
                String currency = listExchangeRates
                        .stream()
                        .findFirst()
                        .map(ExchangeRates::getCurrency).get().name();
                plot.plot().color(COLOR_DICT.get(color_counter).toString()).add(rate).label(currency);
                color_counter++;
            }
            plot.legend().loc("best");
            plot.savefig(this.getClass()
                    .getClassLoader().getResource("").getPath().substring(1) + "graph.png");
            plot.executeSilently();
        } catch (NullPointerException | IOException | PythonExecutionException e) {
            log.error(e.getMessage(), e);
            throw new CreateGraphException();
        }
    }

}
