package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResultAlgorithmIsEmptyException extends RuntimeException {
    public ResultAlgorithmIsEmptyException() {
        super("Result of Algorithm is null!");
        log.error("Result of Algorithm is null!");
    }
}
