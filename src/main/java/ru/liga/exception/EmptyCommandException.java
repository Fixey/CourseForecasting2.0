package ru.liga.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmptyCommandException extends RuntimeException {
    public EmptyCommandException() {
        super("Command is empty!");
        log.error("Command is empty!");
    }
}
