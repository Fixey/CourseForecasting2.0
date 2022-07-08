package ru.liga.fat.back;

import lombok.Getter;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Предсказзаные курсы
 */
@Getter
public class RatesPrediction {
    /**
     * Курсы которые есть в listExchangeRates
     */
    private List<CurrencyType> currencies = new LinkedList<>();

    /**
     * Лист всех предсказаных курсов
     */
    private List<ExchangeRates> listExchangeRates = new LinkedList<>();

    /**
     * Добавить в список курсов
     *
     * @param listExchangeRates список курсов
     */
    public void addListExchangeRates(List<ExchangeRates> listExchangeRates) {
        this.listExchangeRates.addAll(listExchangeRates);
        List<CurrencyType> currencyTypes = listExchangeRates
                .stream()
                .map(ExchangeRates::getCurrency)
                .distinct()
                .collect(Collectors.toList());
        this.addCurrency(currencyTypes);
    }

    /**
     * Добавить в список ставок курс
     *
     * @param listCurrency спиоск курсов
     */
    public void addCurrency(List<CurrencyType> listCurrency) {
        this.currencies.addAll(listCurrency);
    }

    /**
     * Список курсов определенной валюты
     *
     * @param currency курс
     * @return List<BigDecimal> список курсов
     */
    public List<BigDecimal> getRateByCurrency(CurrencyType currency) {
        return this.listExchangeRates
                .stream()
                .filter(exchangeRates -> exchangeRates.getCurrency() == currency)
                .sorted(Comparator.comparing(ExchangeRates::getDate))
                .map(ExchangeRates::getRate)
                .collect(Collectors.toList());
    }

    /**
     * Список ставок определенной валюты
     *
     * @param currency курс
     * @return List<BigDecimal> список курсов
     */

    public List<ExchangeRates> getExchangeRatesByCurrency(CurrencyType currency) {
        return this.listExchangeRates
                .stream()
                .filter(exchangeRates -> exchangeRates.getCurrency() == currency)
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .collect(Collectors.toList());
    }
}
