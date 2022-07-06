package ru.liga.fat.exception;


public class PeriodOrDateRequiredException extends RuntimeException {
    public PeriodOrDateRequiredException() {
        super("Period or Date in command 'rate' is required!");
    }
}
