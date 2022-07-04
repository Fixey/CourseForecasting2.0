package ru.liga.fat.front;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.liga.fat.back.ExchangeRates;
import ru.liga.fat.exception.SendMessageException;
import ru.liga.fat.telegram.Bot;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static ru.liga.fat.constant.ConstantUtil.GRAPH_PATH;

/**
 * Вывод графика
 */
@Slf4j
public class OutputGraph implements IOutputRateCommander {
    /**
     * Вывод графика
     *
     * @param listsExchangeRates название output
     * @param chatId             Id чата
     * @param bot                инстанс бота
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @SneakyThrows
    @Override
    public void sendToOut(List<List<ExchangeRates>> listsExchangeRates, String chatId, Bot bot) {
        log.debug("OutputList args:");
        log.debug("listsExchangeRates =" + listsExchangeRates.toString());
        log.debug("chatId =" + chatId);
        new GraphBuilder().createGraph(listsExchangeRates);
        log.debug("Created successfully");
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(GRAPH_PATH)).getFile());
        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatId)
                .photo(new InputFile(file))
                .build();
        try {
            bot.execute(sendPhoto);
            log.info("Send picture");
        } catch (TelegramApiException e) {
            log.error(e.getMessage(), e);
            throw new SendMessageException();
        }
    }
}
