package ru.liga.fat.back;

import lombok.Data;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RatesPrediction {
    public List<CurrencyType> currencies = new LinkedList<>();
    public List<ExchangeRates> listExchangeRates = new LinkedList<>();

    public void addListExchangeRates(List<ExchangeRates> listExchangeRates) {
        this.listExchangeRates.addAll(listExchangeRates);
    }

    public void addCurrency(CurrencyType currency) {
        this.currencies.add(currency);
    }

    public List<BigDecimal> getRateByCurrency(CurrencyType currency) {
        List<BigDecimal> rate = this.listExchangeRates
                .stream()
                .filter(exchangeRates -> exchangeRates.getCurrency() == currency)
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .map(ExchangeRates::getRate)
                .collect(Collectors.toList());
        return rate;
    }
    public List<ExchangeRates> getExchangeRatesByCurrency(CurrencyType currency) {
        List<ExchangeRates> listExchangeRates = this.listExchangeRates
                .stream()
                .filter(exchangeRates -> exchangeRates.getCurrency() == currency)
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .collect(Collectors.toList());
        return listExchangeRates;
    }
}
