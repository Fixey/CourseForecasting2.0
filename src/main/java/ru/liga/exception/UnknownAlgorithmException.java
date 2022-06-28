package ru.liga.exception;

public class UnknownAlgorithmException extends RuntimeException {
    public UnknownAlgorithmException() {
        super("Such Algorithm is not exist!");
    }
}