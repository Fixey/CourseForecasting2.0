package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArgumentCommandException extends RuntimeException {
    public ArgumentCommandException() {
        super("Number of arguments is incorrect");
        log.error("Number of arguments is incorrect");
    }
}