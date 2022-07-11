package ru.liga.fat.csvfile.exception;


public class FailReadFile extends RuntimeException {
    public FailReadFile() {
        super("Can't read file");
    }
}
