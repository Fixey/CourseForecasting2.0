package ru.liga.front;

import lombok.NonNull;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.enums.AlgorithmType;
import ru.liga.enums.CurrencyType;
import ru.liga.enums.Period;
import ru.liga.exception.*;

import static ru.liga.constant.ConstantUtil.DATE_REGEX;

/**
 * Проверка на корректное написание команды Rate
 */
public class CommandRateValidation {
    /**
     * Проверка на корректное написание команды Rate
     *
     * @param cmd полная комманда
     * @throws ArgumentCommandException падает при ошибке в кол-ве аргуметодов команды
     * @throws CurrencyRateException    падает при отсутсвии такого курса
     * @throws PeriodRateException      падает при непонятном периоде
     */
    public void ValidCmdCommandRate(@NonNull CommandLine cmd) {
        final String[] arrArgs = cmd.getArgs();
        if (arrArgs.length == 0) {
            throw new EmptyCommandException();
        }
        String[] currencies = arrArgs[1].split(",");
        for (String currency : currencies) {
            if (!EnumUtils.isValidEnumIgnoreCase(CurrencyType.class, currency)) {
                throw new CurrencyRateException(currency);
            }
        }
        if (cmd.hasOption("period") && !cmd.hasOption("output")) {
            throw new PeriodRequiredInRateCommandException();
        }
        if (cmd.hasOption("date") && cmd.hasOption("period")) {
            throw new PeriodOrDateRequiredException();
        }
        if (cmd.hasOption("date")) {
            if (!cmd.getOptionValue("date").matches(DATE_REGEX) &&
                    !EnumUtils.isValidEnumIgnoreCase(Period.class, cmd.getOptionValue("date"))) {
                throw new DateRateException();
            }
        }
        if (cmd.hasOption("period")) {
            if (!cmd.getOptionValue("period").matches(DATE_REGEX) &&
                    !EnumUtils.isValidEnumIgnoreCase(Period.class, cmd.getOptionValue("period"))) {
                throw new PeriodRateException();
            }
        }
        if (cmd.hasOption("alg")) {
            if (!EnumUtils.isValidEnumIgnoreCase(AlgorithmType.class, cmd.getOptionValue("alg"))) {
                throw new AlgorithmNotExistException();
            }
        }
    }
}
