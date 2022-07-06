package ru.liga.fat.exception;


public class FailFileException extends RuntimeException {
    public FailFileException() {
        super("Something with file. I can't open it!");
    }
}
