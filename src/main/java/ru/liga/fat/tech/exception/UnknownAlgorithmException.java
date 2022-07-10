package ru.liga.fat.tech.exception;


public class UnknownAlgorithmException extends RuntimeException {
    public UnknownAlgorithmException() {
        super("Such Algorithm is not exist!");
    }
}