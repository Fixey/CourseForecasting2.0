package ru.liga.fat.exception;


public class SendMessageException extends RuntimeException {
    public SendMessageException() {
        super("Can't send message!");
    }
}