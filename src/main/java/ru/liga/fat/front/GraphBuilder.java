package ru.liga.fat.front;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.CreateGraphException;

import java.io.IOException;

import static ru.liga.fat.constant.ConstantUtil.COLOR_DICT;

/**
 * Создание графиков
 */
@Slf4j
public class GraphBuilder {
    /**
     * Создает график
     *
     * @param ratesPrediction объект курсов для разных валют
     * @throws CreateGraphException падает при не успехе создания графика
     */
    public void createGraph(RatesPrediction ratesPrediction) {
        try {
            log.debug("Invoke GraphBuilder.createGraph()");
            log.debug("ratesPrediction ListExchangeRates = " + ratesPrediction.getListExchangeRates().toString());
            log.debug("ratesPrediction currencies = " + ratesPrediction.getCurrencies().toString());
            Plot plot = Plot.create();
            int color_counter = 0;
            for (CurrencyType currency : ratesPrediction.getCurrencies()) {
                plot.plot().color(COLOR_DICT.get(color_counter))
                        .add(ratesPrediction.getRateByCurrency(currency))
                        .label(currency.name());
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
