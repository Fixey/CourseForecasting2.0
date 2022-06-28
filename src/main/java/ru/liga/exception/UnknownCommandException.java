package ru.liga.exception;

public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException() {
        super("Unknown command");
    }
}