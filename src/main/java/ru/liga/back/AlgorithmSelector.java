package ru.liga.back;

import ru.liga.enums.AlgorithmType;
import ru.liga.exception.UnknownAlgorithmException;

/**
 * Выбор алгоритма
 */
public class AlgorithmSelector {
    /**
     * Выбирает алгоритм
     *
     * @param algorithmName название алгоритма
     * @return RateAlgorithm Инстанс алгоритма
     * @throws UnknownAlgorithmException падает если не существует такого алгоритма
     */
    public RateAlgorithm getAlgorithm(AlgorithmType algorithmName) {
        if (algorithmName.name().equals("moon")) {
            return new AlgorithmMoonForecasting();
        } else if (algorithmName.name().equals("mist")) {
            return new AlgorithmMistForecasting();
        } else if (algorithmName.name().equals("web")) {
            return new AlgorithmMoonForecasting();
        }
        throw new UnknownAlgorithmException();
    }
}
