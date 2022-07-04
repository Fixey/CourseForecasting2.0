package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleArgsException extends RuntimeException {
    public ConsoleArgsException() {
        super("Command is wrong!");
        log.error("Command is wrong!");
    }
}
