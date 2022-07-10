package ru.liga.fat.business;

import ru.liga.fat.tech.Configurations;
import ru.liga.fat.tech.enums.AlgorithmType;
import ru.liga.fat.tech.exception.UnknownAlgorithmException;
import ru.liga.fat.tech.entity.ExchangeRates;

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
