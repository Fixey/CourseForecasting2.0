package ru.liga.fat.tech.exception;


public class CreateGraphException extends RuntimeException {
    public CreateGraphException() {
        super("Can't create graph!");
    }
}