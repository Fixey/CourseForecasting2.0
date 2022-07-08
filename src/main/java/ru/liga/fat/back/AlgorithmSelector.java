package ru.liga.fat.back;

import ru.liga.fat.enums.AlgorithmType;
import ru.liga.fat.exception.UnknownAlgorithmException;
import ru.liga.fat.front.IAlgorithmSelector;

import java.util.List;

/**
 * Выбор алгоритма
 */
public class AlgorithmSelector implements IAlgorithmSelector {
    final private List<ExchangeRates> listExchangeRates;

    public AlgorithmSelector() {
        this.listExchangeRates = Configurations.init().getListExchangeRatesFromFile();
    }

    /**
     * Выбирает алгоритм
     *
     * @param algorithmName название алгоритма
     * @return RateAlgorithm Инстанс алгоритма
     * @throws UnknownAlgorithmException падает если не существует такого алгоритма
     */
    public IRateAlgorithm getAlgorithm(AlgorithmType algorithmName) {
        switch (algorithmName) {
            case moon:
                return new AlgorithmMoonForecasting(listExchangeRates);
            case mist:
                return new AlgorithmMistForecasting(listExchangeRates);
            case web:
                return new AlgorithmWebForecasting(listExchangeRates);
        }
        throw new UnknownAlgorithmException();
    }
}
