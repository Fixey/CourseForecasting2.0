package ru.liga.fat.exception;


public class FailReadFile extends RuntimeException {
    public FailReadFile() {
        super("Can't read file");
    }
}
