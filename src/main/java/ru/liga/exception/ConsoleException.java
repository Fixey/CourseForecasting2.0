package ru.liga.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleException extends RuntimeException {
    public ConsoleException(Exception e) {
        super("ConsoleApp have some Error:\n" + e);
        log.error("ConsoleApp have some Error:\n" + e);
    }

}

