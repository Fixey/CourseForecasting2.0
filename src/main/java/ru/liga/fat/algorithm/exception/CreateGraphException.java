package ru.liga.fat.algorithm.exception;


public class CreateGraphException extends RuntimeException {
    public CreateGraphException() {
        super("Can't create graph!");
    }
}