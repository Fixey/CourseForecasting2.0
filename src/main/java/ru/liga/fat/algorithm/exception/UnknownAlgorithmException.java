package ru.liga.fat.algorithm.exception;


public class UnknownAlgorithmException extends RuntimeException {
    public UnknownAlgorithmException() {
        super("Such Algorithm is not exist!");
    }
}