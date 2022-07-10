package ru.liga.fat.tech;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.fat.tech.exception.SendMessageException;

import java.io.File;

/**
 * Отправление сообщения
 */
@Slf4j
public class SendingMessageEngine implements ISendingMessage {
    /**
     * Отпрвляет сообщение
     *
     * @param bot            bot
     * @param chatId         чат id
     * @param sendingMessage объект с соощениями которые надо отправить
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @Override
    public void sendMessageToClient(Bot bot, String chatId, SendingMessage sendingMessage) {
        for (String message : sendingMessage.getListMessage()) {
            sendMessage(bot, chatId, message);
        }
        for (File file : sendingMessage.getListFile()) {
            sendFile(bot, chatId, file);
        }
    }

    /**
     * Отпрвляет сообщение
     *
     * @param bot         bot
     * @param chatId      чат id
     * @param messageText текст сообщения
     * @throws SendMessageException ошибка при отправке сообщения
     */
    public void sendMessage(Bot bot, String chatId, String messageText) {
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

    /**
     * Отпрвляет сообщение
     *
     * @param bot    bot
     * @param chatId чат id
     * @param file   файл
     * @throws SendMessageException ошибка при отправке сообщения
     */
    public void sendFile(Bot bot, String chatId, File file) {
        try {
            SendPhoto sendPhoto = SendPhoto.builder()
                    .chatId(chatId)
                    .photo(new InputFile(file))
                    .build();
            bot.execute(sendPhoto);
            log.info("Send picture");
        } catch (TelegramApiException e) {
            log.error(e.getMessage(), e);
            throw new SendMessageException();
        }
    }
}
