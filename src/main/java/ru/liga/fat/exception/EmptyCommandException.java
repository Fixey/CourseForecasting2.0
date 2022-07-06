package ru.liga.fat.exception;


public class EmptyCommandException extends RuntimeException {
    public EmptyCommandException() {
        super("Command is empty!");
    }
}
