package ru.liga.front;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.back.AlgorithmSelector;
import ru.liga.back.ExchangeRates;
import ru.liga.back.RateAlgorithm;
import ru.liga.enums.AlgorithmType;
import ru.liga.enums.CurrencyType;
import ru.liga.exception.CountDaysException;
import ru.liga.util.PeriodUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс отвечающий за действия по команде Rate
 */
@Slf4j
public class CommandRate implements Command {

    /**
     * Запуск блока команд рассчитывающий курс на период
     *
     * @param fullCommand полная комманда
     * @throws CountDaysException при не возможности подсчитать кол-во дней
     */
    public List invoke(String fullCommand) {
        log.info("Invoked " + this.getClass().getName());
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        //Валидация
        log.debug("Start command validation");
        new CommandRateValidation().ValidCmdCommandRate(cmd);//Проверим корректное написание команды
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
        RateAlgorithm algorithm = new AlgorithmSelector()
                .getAlgorithm(EnumUtils.getEnumIgnoreCase(AlgorithmType.class, algorithmName));
        log.info("Choose algorithm = " + algorithm.getClass().getName());
        List<List<ExchangeRates>> listsExchangeRates = new ArrayList<>();
        for (CurrencyType currency : currencies) {
            if (period != null) {
                listsExchangeRates.add(algorithm.getListExchangeRates(currency, numDays));
            } else {
                listsExchangeRates.add(algorithm.getListExchangeRates(currency, lDate));
            }
        }
        return listsExchangeRates;
    }
}
