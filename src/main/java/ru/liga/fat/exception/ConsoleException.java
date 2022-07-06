package ru.liga.fat.exception;


public class ConsoleException extends RuntimeException {
    public ConsoleException(Exception e) {
        super("ConsoleApp have some Error:\n" + e);
    }

}

