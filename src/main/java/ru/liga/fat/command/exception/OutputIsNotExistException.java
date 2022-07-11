package ru.liga.fat.command.exception;


public class OutputIsNotExistException extends RuntimeException {
    public OutputIsNotExistException() {
        super("Such Output in command 'rate' is not exist!");
    }
}
