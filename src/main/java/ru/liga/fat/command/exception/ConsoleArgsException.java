package ru.liga.fat.command.exception;

public class ConsoleArgsException extends RuntimeException {
    public ConsoleArgsException() {
        super("Command is wrong!");
    }
}
