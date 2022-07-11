package ru.liga.fat.command.exception;


public class UnknownCommandException extends RuntimeException {
    public UnknownCommandException() {
        super("Unknown command");
    }
}