package ru.liga.exception;

public class CurrencyRateException extends RuntimeException {
    public CurrencyRateException() {
        super("Such Currency in command 'rate' is not exist!");
    }
}
