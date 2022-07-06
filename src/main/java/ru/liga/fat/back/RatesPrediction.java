package ru.liga.fat.back;

import lombok.Data;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Предсказзаные курсы
 */
@Data
public class RatesPrediction {
    /**
     * Курсы которые есть в listExchangeRates
     */
    public List<CurrencyType> currencies = new LinkedList<>();
    /**
     * Лист всех предсказаных курсов
     */
    public List<ExchangeRates> listExchangeRates = new LinkedList<>();

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
     * @param currency currency курс
     */
    public void addCurrency(CurrencyType currency) {
        this.currencies.add(currency);
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
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
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
