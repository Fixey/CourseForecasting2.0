package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class ArgumentsOptionFormatterException extends RuntimeException {
    public ArgumentsOptionFormatterException() {
        super("Command wrote wrong!");
        log.error("Command wrote wrong!");
    }
}
