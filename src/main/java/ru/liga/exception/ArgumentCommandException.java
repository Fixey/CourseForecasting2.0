package ru.liga.exception;

public class ArgumentCommandException extends RuntimeException {
    public ArgumentCommandException() {
        super("Number of arguments is incorrect");
    }
}