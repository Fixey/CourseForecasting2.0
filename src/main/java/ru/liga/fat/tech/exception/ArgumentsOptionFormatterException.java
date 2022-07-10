package ru.liga.fat.tech.exception;


public class ArgumentsOptionFormatterException extends RuntimeException {
    public ArgumentsOptionFormatterException(Exception e) {
        super("Command wrote wrong!" + e);
    }
}
