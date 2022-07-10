package ru.liga.fat.tech.exception;


public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException() {
        super("Unknown command");
    }
}