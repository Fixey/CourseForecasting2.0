package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PeriodOrDateRequiredException extends RuntimeException {
    public PeriodOrDateRequiredException() {
        super("Period or Date in command 'rate' is required!");
        log.error("Period or Date in command 'rate' is required!");
    }
}
