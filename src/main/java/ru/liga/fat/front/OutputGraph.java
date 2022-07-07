package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.exception.SendMessageException;

import java.io.File;
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
     * @param ratesPrediction название output
     * @param chatId          Id чата
     * @return File файл
     * @throws SendMessageException ошибка при отправке сообщения
     */

    @Override
    public SendingMessage getMessage(RatesPrediction ratesPrediction, String chatId) {
        log.debug("OutputList args:");
        log.debug("listsExchangeRates =" + ratesPrediction.toString());
        log.debug("chatId =" + chatId);
        new GraphBuilder().createGraph(ratesPrediction);
        log.debug("Created successfully");
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(GRAPH_PATH)).getFile());
        SendingMessage sendingMessage = new SendingMessage();
        sendingMessage.addFile(file);
        return sendingMessage;
    }
}
