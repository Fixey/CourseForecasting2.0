package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnknownAlgorithmException extends RuntimeException {
    public UnknownAlgorithmException() {
        super("Such Algorithm is not exist!");
        log.error("Such Algorithm is not exist!");
    }
}