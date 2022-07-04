package ru.liga.front;

import ru.liga.back.IRateAlgorithm;
import ru.liga.enums.AlgorithmType;

public interface IAlgorithmSelector {
    IRateAlgorithm getAlgorithm(AlgorithmType algorithmName);
}
