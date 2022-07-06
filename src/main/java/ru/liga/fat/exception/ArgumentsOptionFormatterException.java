package ru.liga.fat.exception;


public class ArgumentsOptionFormatterException extends RuntimeException {
    public ArgumentsOptionFormatterException() {
        super("Command wrote wrong!");
    }
}
