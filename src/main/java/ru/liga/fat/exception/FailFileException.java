package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FailFileException extends RuntimeException {
    public FailFileException() {
        super("Something with file. I can't open it!");
        log.error("Something with file. I can't open it!");
    }
}
