package ru.liga.fat.tech.exception;


public class CountDaysException extends RuntimeException {
    public CountDaysException() {
        super("Can't count days");
    }
}
