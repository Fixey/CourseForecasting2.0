package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutputIsNotExistException extends RuntimeException {
    public OutputIsNotExistException() {
        super("Such Output in command 'rate' is not exist!");
        log.error("Such Output in command 'rate' is not exist!");
    }
}
