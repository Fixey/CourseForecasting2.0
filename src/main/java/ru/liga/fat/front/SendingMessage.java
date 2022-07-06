package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.fat.exception.SendMessageException;
import ru.liga.fat.telegram.Bot;

@Slf4j
public class SendingMessage implements ISendingMessage {
    @Override
    public void sendMessageToClient(Bot bot, String chatId, String messageText) {
        try {
            SendMessage sendMessage = SendMessage.builder()
                    .chatId(chatId)
                    .text(messageText)
                    .build();
            bot.execute(sendMessage);
            log.info("Send list to client");
        } catch (TelegramApiException e) {
            log.error(e.getMessage(), e);
            throw new SendMessageException();
        }
    }
}
