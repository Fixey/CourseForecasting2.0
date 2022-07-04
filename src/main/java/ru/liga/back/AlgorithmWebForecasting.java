package ru.liga.back;

import lombok.extern.slf4j.Slf4j;
import ru.liga.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.liga.constant.ConstantUtil.FORECASTING_WEB_NUM;

/**
 * Алгоритм рассчета "Интернет"
 */
@Slf4j
public class AlgorithmWebForecasting implements IRateAlgorithm {
    private List<ExchangeRates> exchangeRatesFromFiles;

    public AlgorithmWebForecasting(List<ExchangeRates> exchangeRatesFromFiles) {
        this.exchangeRatesFromFiles = exchangeRatesFromFiles;
    }

    /**
     * Выполнение алгоритма и вывод результата
     *
     * @param currency тип валюты
     * @param date     дата на который надо предсказать
     * @return List Результат выполнения алгоритма
     */
    @Override
    public List<ExchangeRates> getListExchangeRates(CurrencyType currency, LocalDate date) {
        log.debug("AlgorithmWebForecasting.getListExchangeRates().args:");
        log.debug("currency = " + currency.name());
        log.debug("date = " + date);
        List<ExchangeRates> listExchangeRate = getListForecastingRates(currency, date);

        return listExchangeRate.
                stream()
                .max(Comparator.comparing(ExchangeRates::getDate))
                .stream()
                .collect(Collectors.toList());
    }

    /**
     * Выполнение алгоритма и вывод результата
     *
     * @param currency тип валюты
     * @param period   кол-во дней на сколько надо предсказать курса
     * @return List Результат выполнения алгоритма
     */
    @Override
    public List<ExchangeRates> getListExchangeRates(CurrencyType currency, Integer period) {
        log.debug("AlgorithmWebForecasting.getListExchangeRates().args:");
        log.debug("currency = " + currency.name());
        log.debug("period = " + period);
        LocalDate localDate = LocalDate.now().plusDays(period);
        List<ExchangeRates> listExchangeRate = getListForecastingRates(currency, localDate);

        return listExchangeRate.stream()
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .limit(period)
                .collect(Collectors.toList());
    }

    private List<ExchangeRates> getListForecastingRates(CurrencyType currency, LocalDate date) {
        double[] arrRates = exchangeRatesFromFiles.stream()
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .limit(FORECASTING_WEB_NUM)
                .map(ExchangeRates::getRate)
                .mapToDouble(BigDecimal::doubleValue)
                .toArray();
        double[] rangeDays = IntStream.rangeClosed(1, FORECASTING_WEB_NUM)
                .boxed()
                .mapToDouble(i -> i)
                .toArray();
        List<ExchangeRates> listExchangeRates = exchangeRatesFromFiles.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency().equals(currency))
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .limit(FORECASTING_WEB_NUM).collect(Collectors.toList());
        LocalDate lastDateLineExchangeRate = listExchangeRates.get(0).getDate();
        double dayCounter =0.0;
        while (!date.isEqual(lastDateLineExchangeRate)) {
            dayCounter++;
            LinearRegression linearRegression = new LinearRegression(rangeDays, arrRates);
            BigDecimal rate = new BigDecimal(linearRegression.predict(FORECASTING_WEB_NUM.doubleValue()+dayCounter));
            lastDateLineExchangeRate = lastDateLineExchangeRate.plusDays(1);
            listExchangeRates.add(new ExchangeRates(currency, rate, lastDateLineExchangeRate));
        }
        return listExchangeRates;
    }
}
