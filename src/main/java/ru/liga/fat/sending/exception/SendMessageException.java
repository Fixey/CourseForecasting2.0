package ru.liga.fat.sending.exception;


public class SendMessageException extends RuntimeException {
    public SendMessageException() {
        super("Can't send message!");
    }
}