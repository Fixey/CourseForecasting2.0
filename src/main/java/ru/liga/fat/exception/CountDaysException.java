package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountDaysException extends RuntimeException {
    public CountDaysException() {
        super("Can't count days");
        log.error("Can't count days");
    }
}
