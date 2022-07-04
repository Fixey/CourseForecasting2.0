package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateRateException extends RuntimeException {
    public DateRateException() {
        super("Such Date in command 'rate' is not exist!");
        log.error("Such Date in command 'rate' is not exist!");
    }
}