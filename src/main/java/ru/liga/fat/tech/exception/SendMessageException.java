package ru.liga.fat.tech.exception;


public class SendMessageException extends RuntimeException {
    public SendMessageException() {
        super("Can't send message!");
    }
}