package ru.liga.fat.telegram;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.fat.enums.OutputCommandType;
import ru.liga.fat.exception.ArgumentsOptionFormatterException;
import ru.liga.fat.exception.SendMessageException;
import ru.liga.fat.front.CommandHandler;
import ru.liga.fat.front.FormerConsoleArguments;
import ru.liga.fat.front.IOutputRateCommander;
import ru.liga.fat.front.OutputSelector;

import java.util.Arrays;
import java.util.List;

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
            List listResult;
            try {
                listResult = new CommandHandler().consoleEngine(messageText);
                log.debug("Result Algorithm: " + listResult.toString());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                SendMessage sendMessage = SendMessage.builder()
                        .chatId(chatId)
                        .text(e.getMessage())
                        .build();
                try {
                    this.execute(sendMessage);
                } catch (TelegramApiException ex) {
                    log.error(e.getMessage(), e);
                    throw new SendMessageException();
                }
                log.error(e.getMessage(), e);
                throw new SendMessageException();
            }
            //Выбор обработки результата алгоритма предсказаний
            try {
                log.debug("Select algorithm for output");
                CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(messageText);
                log.debug("CMD=" + Arrays.toString(cmd.getArgs()));
                if (cmd.hasOption("output")) {
                    IOutputRateCommander outputRateCommander = new OutputSelector().getOutput(OutputCommandType.valueOf(cmd.getOptionValue("output")));
                    log.debug("outputRateCommander = " + outputRateCommander.getClass().getName());
                    outputRateCommander.sendToOut(listResult, chatId, this);
                }
            } catch (RuntimeException e) {
                log.error(e.getMessage(), e);
                throw new ArgumentsOptionFormatterException();
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