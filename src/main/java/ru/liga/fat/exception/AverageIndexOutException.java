package ru.liga.fat.exception;


public class AverageIndexOutException extends RuntimeException {
    public AverageIndexOutException() {
        super("getAverageRate was failed. Possible listLines is empty");
    }
}
