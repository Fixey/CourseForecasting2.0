package ru.liga.fat.tech.exception;


public class OutputIsNotExistException extends RuntimeException {
    public OutputIsNotExistException() {
        super("Such Output in command 'rate' is not exist!");
    }
}
