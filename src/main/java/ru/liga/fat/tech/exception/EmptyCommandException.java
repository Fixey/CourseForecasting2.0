package ru.liga.fat.tech.exception;


public class EmptyCommandException extends RuntimeException {
    public EmptyCommandException() {
        super("Command is empty!");
    }
}
