package ru.liga;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.liga.back.Configurations;
import ru.liga.telegram.Bot;

/**
 * Запуск программы
 */
@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        log.info("Start Bot");
        new Configurations();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new Bot());
    }
}

