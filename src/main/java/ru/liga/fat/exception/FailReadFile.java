package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FailReadFile extends RuntimeException {
    public FailReadFile() {
        super("Can't read file");
        log.error("Can't read file");
    }
}
