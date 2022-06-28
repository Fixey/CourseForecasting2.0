package ru.liga.exception;

public class ConsoleArgsException extends RuntimeException {
    public ConsoleArgsException() {
        super("Command is wrong!");
    }
}
