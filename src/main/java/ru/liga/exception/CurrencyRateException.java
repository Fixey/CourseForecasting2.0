package ru.liga.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrencyRateException extends RuntimeException {
    public CurrencyRateException(String currency) {
        super("Such Currency "+currency+" in command 'rate' is not exist!");
        log.error("Such Currency "+currency+" in command 'rate' is not exist!");
    }
}
