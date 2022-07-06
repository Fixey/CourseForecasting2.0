package ru.liga.fat.exception;


public class CurrencyRateException extends RuntimeException {
    public CurrencyRateException(String currency) {
        super("Such Currency " + currency + " in command 'rate' is not exist!");
    }
}
