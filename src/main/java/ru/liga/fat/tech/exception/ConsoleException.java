package ru.liga.fat.tech.exception;


public class ConsoleException extends RuntimeException {
    public ConsoleException(Exception e) {
        super("ConsoleApp have some Error:\n" + e);
    }

}

