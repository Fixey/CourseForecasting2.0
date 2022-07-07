package ru.liga.fat.back;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static ru.liga.fat.constant.ConstantUtil.FORECASTING_MIST_NUM;

/**
 * Алгоритм рассчета "Мистический"
 */
@Slf4j
public class AlgorithmMistForecasting implements IRateAlgorithm {
    final private List<ExchangeRates> exchangeRatesFromFiles;

    public AlgorithmMistForecasting(List<ExchangeRates> exchangeRatesFromFiles) {
        this.exchangeRatesFromFiles = exchangeRatesFromFiles;
    }

    /**
     * Алгоритм “Мистический”.
     * Для каждого следующего дня берёте рандомно один из 30 предыдущих дней включая рассчитанные таким образом.
     *
     * @param currency Валюта
     * @param date     рассчитывать на определенный день
     * @return List<ExchangeRates> лист Курса валют
     */
    @Override
    public List<ExchangeRates> getListExchangeRates(CurrencyType currency, LocalDate date) {
        log.debug("AlgorithmMistForecasting.getListExchangeRates().args:");
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
     * Алгоритм “Мистический”.
     * Для каждого следующего дня берёте рандомно один из 30 предыдущих дней включая рассчитанные таким образом.
     *
     * @param currency Валюта
     * @param period   на сколько дней рассчитывать
     * @return List<ExchangeRates> лист Курса валют
     */
    @Override
    public List<ExchangeRates> getListExchangeRates(CurrencyType currency, Integer period) {
        log.debug("AlgorithmMistForecasting.getListExchangeRates().args:");
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
        FilesStatement filesStatement = new FilesStatement();
        List<ExchangeRates> listExchangeRates = filesStatement.getListExchangeRatesByCurrency(currency,
                FORECASTING_MIST_NUM);
        LocalDate lastDateLineExchangeRate = listExchangeRates.get(0).getDate();
        while (!date.isEqual(lastDateLineExchangeRate)) {
            List<BigDecimal> listRates = filesStatement.getRatesByCurrent(currency, FORECASTING_MIST_NUM);
            Random rand = new Random();
            final int random_integer = rand.nextInt(listRates.size());
            BigDecimal rate = listRates.get(random_integer);
            lastDateLineExchangeRate = lastDateLineExchangeRate.plusDays(1);
            listExchangeRates.add(new ExchangeRates(currency, rate, lastDateLineExchangeRate));
        }
        return listExchangeRates;
    }
}
