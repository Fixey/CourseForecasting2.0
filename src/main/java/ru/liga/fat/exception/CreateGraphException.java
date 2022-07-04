package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateGraphException extends RuntimeException {
    public CreateGraphException() {
        super("Can't create graph!");
        log.error("Can't create graph!");
    }
}