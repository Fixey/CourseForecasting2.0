package ru.liga.fat.tech.exception;

public class ConsoleArgsException extends RuntimeException {
    public ConsoleArgsException() {
        super("Command is wrong!");
    }
}
