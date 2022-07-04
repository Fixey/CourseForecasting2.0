package ru.liga.fat.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendMessageException extends RuntimeException {
    public SendMessageException() {
        super("Can't send message!");
        log.error("Can't send message!");
    }
}