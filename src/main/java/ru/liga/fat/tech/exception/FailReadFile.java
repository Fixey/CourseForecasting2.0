package ru.liga.fat.tech.exception;


public class FailReadFile extends RuntimeException {
    public FailReadFile() {
        super("Can't read file");
    }
}
