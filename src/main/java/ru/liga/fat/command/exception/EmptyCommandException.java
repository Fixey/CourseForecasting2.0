package ru.liga.fat.command.exception;


public class EmptyCommandException extends RuntimeException {
    public EmptyCommandException() {
        super("Command is empty!");
    }
}
