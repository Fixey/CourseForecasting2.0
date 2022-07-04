package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PeriodRequiredInRateCommandException extends RuntimeException {
    public PeriodRequiredInRateCommandException() {
        super("Output is required parameter if there is period!");
        log.error("Output is required parameter if there is period!");
    }
}
