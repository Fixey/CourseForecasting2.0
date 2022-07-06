package ru.liga.fat.exception;

public class AlgorithmNotExistException extends RuntimeException {
    public AlgorithmNotExistException() {
        super("Such Algorithm in command 'rate' is not exist!");
    }
}