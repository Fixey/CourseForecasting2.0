package ru.liga.fat.front;

import ru.liga.fat.telegram.Bot;

import java.io.File;

public interface ISendingMessage {
    void sendMessageToClient(Bot bot, String chatId, SendingMessage Message);
}
