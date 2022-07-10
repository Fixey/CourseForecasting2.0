package ru.liga.fat.tech;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.business.AlgorithmSelector;
import ru.liga.fat.business.IAlgorithmSelector;
import ru.liga.fat.business.IRateAlgorithm;
import ru.liga.fat.tech.enums.CurrencyType;
import ru.liga.fat.tech.exception.CountDaysException;
import ru.liga.fat.tech.entity.RateParameters;
import ru.liga.fat.tech.entity.RatesPrediction;

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
        IRateAlgorithm algorithm = algorithmSelector.getAlgorithm(rateParameters.getAlgorithmType());
        log.info("Choose algorithm = " + algorithm.getClass().getName());
        RatesPrediction ratesPrediction = new RatesPrediction();
        for (CurrencyType currency : rateParameters.getCurrencies()) {
            if (rateParameters.getPeriod() != null) {
                ratesPrediction.addListExchangeRates(algorithm.getListExchangeRates(currency, rateParameters.getPeriod()));
            } else {
                ratesPrediction.addListExchangeRates(algorithm.getListExchangeRates(currency, rateParameters.getDate()));
            }
        }
        return ratesPrediction;
    }
}
