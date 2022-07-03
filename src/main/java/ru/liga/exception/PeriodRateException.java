package ru.liga.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PeriodRateException extends RuntimeException {
    public PeriodRateException() {
        super("Such Period in command 'rate' is not exist!");
        log.error("Such Period in command 'rate' is not exist!");
    }
}