package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException()
    {
        super("Unknown command");
        log.error("Unknown command");
    }
}