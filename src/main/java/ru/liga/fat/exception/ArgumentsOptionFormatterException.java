package ru.liga.fat.exception;


public class ArgumentsOptionFormatterException extends RuntimeException {
    public ArgumentsOptionFormatterException(Exception e) {
        super("Command wrote wrong!" + e);
    }
}
