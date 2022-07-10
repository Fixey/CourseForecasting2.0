package ru.liga.fat.tech;

import ru.liga.fat.tech.entity.ExchangeRates;
import ru.liga.fat.tech.enums.CurrencyType;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.liga.fat.tech.constant.ConstantUtil.FORECASTING_MIST_NUM;

public class FilesStatement {
    private final List<ExchangeRates> listExchangeRates = Configurations.init().getListExchangeRatesFromFile();

    /**
     * Вернуть n объектов Курса взятых из файла отсортерованного от новой даты к старой определенного курса
     *
     * @param currency курс
     * @param limits   сколько нужно значений
     * @return List<ExchangeRates> Список курсов
     */
    public List<ExchangeRates> getListExchangeRatesByCurrency(CurrencyType currency, int limits) {
        return listExchangeRates.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency().equals(currency))
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .limit(limits).collect(Collectors.toList());
    }

    /**
     * Вернуть объекты Курса взятых из файла отсортерованного от новой даты к старой определенного курса
     *
     * @param currency курс
     * @return List<ExchangeRates> Список курсов
     */
    public List<ExchangeRates> getListExchangeRatesByCurrency(CurrencyType currency) {
        return listExchangeRates.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency().equals(currency))
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Вернуть ставку Курса взятых из файла отсортерованного от новой даты к старой определенного курса
     *
     * @param currency курс
     * @param limits   сколько нужно значений
     * @return List<BigDecimal> Список ставок
     */
    public List<BigDecimal> getRatesByCurrent(CurrencyType currency, int limits) {
        return listExchangeRates.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency().equals(currency))
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .limit(FORECASTING_MIST_NUM)
                .map(ExchangeRates::getRate)
                .collect(Collectors.toList());
    }

    /**
     * Вернуть ставку Курса взятых из файла отсортерованного от новой даты к старой определенного курса
     *
     * @param currency  курс
     * @param predicate предикат для фильтра
     * @return List<BigDecimal> Список ставок
     */
    public BigDecimal getRatesBuCurrencyWithFilter(CurrencyType currency, Predicate<ExchangeRates> predicate) {
        return listExchangeRates.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency() == currency)
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .filter(predicate)
                .findFirst().map(ExchangeRates::getRate).get();
    }
}
