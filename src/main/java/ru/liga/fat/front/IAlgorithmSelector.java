package ru.liga.fat.front;

import ru.liga.fat.back.IRateAlgorithm;
import ru.liga.fat.enums.AlgorithmType;

public interface IAlgorithmSelector {
    IRateAlgorithm getAlgorithm(AlgorithmType algorithmName);
}
