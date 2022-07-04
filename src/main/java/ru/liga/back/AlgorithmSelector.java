package ru.liga.back;

import ru.liga.enums.AlgorithmType;
import ru.liga.exception.UnknownAlgorithmException;
import ru.liga.front.IAlgorithmSelector;

import java.util.LinkedList;
import java.util.List;

import static ru.liga.back.Configurations.LIST_EXCHANGE_RATES;

/**
 * Выбор алгоритма
 */
public class AlgorithmSelector implements IAlgorithmSelector {
    private List<ExchangeRates> listExchangeRates;

    public AlgorithmSelector() {
        this.listExchangeRates = LIST_EXCHANGE_RATES;
    }
    public AlgorithmSelector(LinkedList<ExchangeRates> listExchangeRates) {
        this.listExchangeRates = listExchangeRates;
    }
    /**
     * Выбирает алгоритм
     *
     * @param algorithmName название алгоритма
     * @return RateAlgorithm Инстанс алгоритма
     * @throws UnknownAlgorithmException падает если не существует такого алгоритма
     */
    public IRateAlgorithm getAlgorithm(AlgorithmType algorithmName) {
        switch (algorithmName.name()) {
            case "moon":
                return new AlgorithmMoonForecasting(listExchangeRates);
            case "mist":
                return new AlgorithmMistForecasting(listExchangeRates);
            case "web":
                return new AlgorithmMoonForecasting(listExchangeRates);
        }
        throw new UnknownAlgorithmException();
    }
}
