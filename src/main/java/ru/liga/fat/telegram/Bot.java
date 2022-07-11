package ru.liga.fat.telegram;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.liga.fat.command.CommandHandler;
import ru.liga.fat.command.CommandParameters;
import ru.liga.fat.command.CommandParametersSelector;
import ru.liga.fat.output.OutputSelector;
import ru.liga.fat.sending.SendingMessage;
import ru.liga.fat.sending.SendingMessageEngine;
import ru.liga.fat.entity.RatesPrediction;
import ru.liga.fat.command.exception.ArgumentsOptionFormatterException;
import ru.liga.fat.sending.exception.SendMessageException;

/**
 * Бот предсказывающий курс
 */
@Slf4j
public final class Bot extends TelegramLongPollingBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;

    public Bot(String botToken, String botName) {
        super();
        this.BOT_TOKEN = botToken;
        this.BOT_NAME = botName;
    }

    /**
     * @param update сообщение полученное от клиента
     * @throws SendMessageException              Не успешная отправка сообщения
     * @throws ArgumentsOptionFormatterException Команда не корректно написана
     */
    @Override
    public void onUpdateReceived(Update update) {

        log.debug("Start");
        log.info("Get message");
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String messageText = message.getText();
            String chatId = message.getChatId().toString();
            log.info(String.format("MessageText = %s,ChatId = %s", messageText, chatId));
            try {
                CommandParameters commandParameters = new CommandParametersSelector().chooseCommand(messageText);
                RatesPrediction ratesPrediction = new CommandHandler().invokeCommandFromConsole(commandParameters);
                log.debug("Result Algorithm: " + ratesPrediction.toString());
                log.debug("Select algorithm for output");
                SendingMessage sendingMessage = new OutputSelector().getMessage(commandParameters, ratesPrediction);
                new SendingMessageEngine().sendMessageToClient(this, chatId, sendingMessage);
            } catch (RuntimeException e) {
                log.error(e.getMessage(), e);
                new SendingMessageEngine().sendMessage(this, chatId, e.getMessage());
                throw new ArgumentsOptionFormatterException(e);
            }
            log.info("Work with command finished");
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}