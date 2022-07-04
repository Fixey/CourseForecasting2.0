package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlgorithmNotExistException extends RuntimeException {
    public AlgorithmNotExistException() {
        super("Such Algorithm in command 'rate' is not exist!");
        log.error("Such Algorithm in command 'rate' is not exist!");
    }
}