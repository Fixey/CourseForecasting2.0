package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AverageIndexOutException  extends RuntimeException {
    public AverageIndexOutException() {
        super("getAverageRate was failed. Possible listLines is empty");
        log.error("getAverageRate was failed. Possible listLines is empty");
    }
}
