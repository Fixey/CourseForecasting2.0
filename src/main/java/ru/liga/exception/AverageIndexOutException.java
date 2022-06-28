package ru.liga.exception;

public class AverageIndexOutException  extends RuntimeException {
    public AverageIndexOutException() {
        super("getAverageRate was failed. Possible listLines is empty");
    }
}
