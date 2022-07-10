package ru.liga.fat.tech.exception;

public class AlgorithmNotExistException extends RuntimeException {
    public AlgorithmNotExistException() {
        super("Such Algorithm in command 'rate' is not exist!");
    }
}