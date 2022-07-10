package ru.liga.fat.tech;

public interface ISendingMessage {
    void sendMessageToClient(Bot bot, String chatId, SendingMessage Message);
}
