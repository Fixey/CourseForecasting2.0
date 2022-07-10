package ru.liga.fat.tech.exception;


public class DateRateException extends RuntimeException {
    public DateRateException() {
        super("Such Date in command 'rate' is not exist!");
    }
}