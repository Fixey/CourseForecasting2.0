package ru.liga.exception;

public class ConsoleException extends RuntimeException {
    public ConsoleException(Exception e) {
        super("ConsoleApp have some Error:\n" + e);
    }

    public ConsoleException() {
        super("ConsoleApp have some Error:\n");
    }
}

