package ru.liga.fat.command.exception;


public class PeriodRateException extends RuntimeException {
    public PeriodRateException() {
        super("Such Period in command 'rate' is not exist!");
    }
}