package ru.liga.fat.algorithm;

import ru.liga.fat.enums.AlgorithmType;

public interface IAlgorithmSelector {
    IRateAlgorithm getAlgorithm(AlgorithmType algorithmName);
}
