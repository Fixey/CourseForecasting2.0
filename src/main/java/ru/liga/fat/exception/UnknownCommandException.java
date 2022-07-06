package ru.liga.fat.exception;


public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException() {
        super("Unknown command");
    }
}