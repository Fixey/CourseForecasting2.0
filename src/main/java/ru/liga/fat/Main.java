package ru.liga.fat;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.liga.fat.back.Configurations;
import ru.liga.fat.telegram.Bot;

/**
 * Запуск программы
 */
@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        log.info("Start Bot");
        Configurations.init();
        String botToken = System.getenv("BOT_FORECASTING_TOKEN");
        String botName = System.getenv("BOT_FORECASTING_NAME");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new Bot(botToken, botName));
    }
}

