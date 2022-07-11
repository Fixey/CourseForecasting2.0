package ru.liga.fat.command.exception;


public class CountDaysException extends RuntimeException {
    public CountDaysException() {
        super("Can't count days");
    }
}
