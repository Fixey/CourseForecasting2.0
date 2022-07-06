package ru.liga.fat.front;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.back.AlgorithmSelector;
import ru.liga.fat.back.IRateAlgorithm;
import ru.liga.fat.back.RatesPrediction;
import ru.liga.fat.enums.AlgorithmType;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.exception.CountDaysException;
import ru.liga.fat.util.PeriodUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс отвечающий за действия по команде Rate
 */
@Slf4j
public class CommandRate implements Command {
    private IAlgorithmSelector algorithmSelector;

    public CommandRate() {
        this.algorithmSelector = new AlgorithmSelector();
    }

    public CommandRate(IAlgorithmSelector algorithmSelector) {
        this.algorithmSelector = algorithmSelector;
    }

    /**
     * Запуск блока команд рассчитывающий курс на период
     *
     * @param fullCommand полная комманда
     * @return RatesPrediction предсказанные курсы
     * @throws CountDaysException при не возможности подсчитать кол-во дней
     */
    public RatesPrediction invoke(String fullCommand) {
        log.info("Invoked " + this.getClass().getName());
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        //Валидация
        log.debug("Start command validation");
        new CommandRateValidation().validCmdCommandRate(cmd);//Проверим корректное написание команды
        log.debug("Validation was successes");
        //Декларация переменных
        List<CurrencyType> currencies = Arrays.stream(cmd.getArgs()[1].split(",")).map(x -> EnumUtils.getEnumIgnoreCase(CurrencyType.class, x)).collect(Collectors.toList());
        String period = cmd.getOptionValue("period");
        String date = cmd.getOptionValue("date");
        LocalDate lDate = null;
        if (date != null) {
            lDate = PeriodUtils.toLocalDateTimeFromPeriod(date);
        }
        String algorithmName = cmd.getOptionValue("alg");
        //высчитываем кол-во дней за период
        Integer numDays = -1;
        if (period != null) {
            numDays = PeriodUtils.countDayForPeriod(period);
            if (numDays == null) {
                throw new CountDaysException();
            }
        }
        log.debug("period = " + period);
        log.debug("date = " + date);
        log.debug("algorithmName = " + algorithmName);
        log.debug("numDays = " + numDays);
        //Выбор алгоритма
        IRateAlgorithm algorithm = algorithmSelector.getAlgorithm(EnumUtils.getEnumIgnoreCase(AlgorithmType.class, algorithmName));
        log.info("Choose algorithm = " + algorithm.getClass().getName());
        RatesPrediction ratesPrediction = new RatesPrediction();
        for (CurrencyType currency : currencies) {
            if (period != null) {
                ratesPrediction.addListExchangeRates(algorithm.getListExchangeRates(currency, numDays));
            } else {
                ratesPrediction.addListExchangeRates(algorithm.getListExchangeRates(currency, lDate));
            }
        }
        return ratesPrediction;
    }
}
