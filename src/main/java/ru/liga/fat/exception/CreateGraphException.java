package ru.liga.fat.exception;


public class CreateGraphException extends RuntimeException {
    public CreateGraphException() {
        super("Can't create graph!");
    }
}