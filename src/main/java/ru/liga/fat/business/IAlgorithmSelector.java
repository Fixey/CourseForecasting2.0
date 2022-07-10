package ru.liga.fat.business;

import ru.liga.fat.tech.enums.AlgorithmType;

public interface IAlgorithmSelector {
    IRateAlgorithm getAlgorithm(AlgorithmType algorithmName);
}
