package ru.liga.fat.front;

import ru.liga.fat.telegram.Bot;

public interface ISendingMessage {
    void sendMessageToClient(Bot bot, String chatId, SendingMessage Message);
}
