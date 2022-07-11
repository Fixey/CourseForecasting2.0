package ru.liga.fat.command.exception;


public class ArgumentsOptionFormatterException extends RuntimeException {
    public ArgumentsOptionFormatterException(Exception e) {
        super("Command wrote wrong!" + e);
    }
}
