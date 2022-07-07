package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.back.AlgorithmSelector;
import ru.liga.fat.back.IRateAlgorithm;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.CountDaysException;

/**
 * Класс отвечающий за действия по команде Rate
 */
@Slf4j
public class CommandRate implements Command {
    final private IAlgorithmSelector algorithmSelector;

    public CommandRate() {
        this.algorithmSelector = new AlgorithmSelector();
    }

    public CommandRate(IAlgorithmSelector algorithmSelector) {
        this.algorithmSelector = algorithmSelector;
    }

    /**
     * Запуск блока команд рассчитывающий курс на период
     *
     * @param commandParameters параметры команды
     * @return RatesPrediction предсказанные курсы
     * @throws CountDaysException при не возможности подсчитать кол-во дней
     */
    public RatesPrediction invoke(CommandParameters commandParameters) {
        RateParameters rateParameters = (RateParameters) commandParameters;
        log.info("Invoked " + this.getClass().getName());
        //Выбор и релазиация алгоритма
        IRateAlgorithm algorithm = algorithmSelector.getAlgorithm(rateParameters.algorithmType);
        log.info("Choose algorithm = " + algorithm.getClass().getName());
        RatesPrediction ratesPrediction = new RatesPrediction();
        for (CurrencyType currency : rateParameters.currencies) {
            if (rateParameters.period != null) {
                ratesPrediction.addListExchangeRates(algorithm.getListExchangeRates(currency, rateParameters.period));
            } else {
                ratesPrediction.addListExchangeRates(algorithm.getListExchangeRates(currency, rateParameters.date));
            }
        }
        return ratesPrediction;
    }
}
