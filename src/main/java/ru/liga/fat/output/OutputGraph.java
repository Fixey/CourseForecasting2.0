package ru.liga.fat.output;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.algorithm.GraphBuilder;
import ru.liga.fat.entity.RatesPrediction;
import ru.liga.fat.sending.SendingMessage;
import ru.liga.fat.sending.exception.SendMessageException;

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
     * @return File файл
     * @throws SendMessageException ошибка при отправке сообщения
     */
    @Override
    public SendingMessage getMessage(RatesPrediction ratesPrediction) {
        log.debug("OutputList args:");
        log.debug("listsExchangeRates =" + ratesPrediction.toString());
        new GraphBuilder().createGraph(ratesPrediction);
        log.debug("Created successfully");
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(GRAPH_PATH)).getFile());
        SendingMessage sendingMessage = new SendingMessage();
        sendingMessage.addFile(file);
        return sendingMessage;
    }
}
