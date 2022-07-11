package ru.liga.fat.command;

import lombok.NonNull;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.command.exception.*;
import ru.liga.fat.enums.AlgorithmType;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.enums.OutputCommandType;
import ru.liga.fat.enums.Period;

import static ru.liga.fat.constant.ConstantUtil.DATE_REGEX;

/**
 * Проверка на корректное написание команды Rate
 */
public class CommandRateValidation {
    /**
     * Проверка на корректное написание команды Rate
     *
     * @param cmd полная комманда
     * @throws EmptyCommandException                падает когда команда пустая
     * @throws CurrencyRateException                падает при непонятном курсе
     * @throws PeriodRequiredInRateCommandException падает при присутствии периода без отпут флага
     * @throws PeriodOrDateRequiredException        падает при отсутствии периода или даты
     * @throws DateRateException                    падает при отсутствии даты в enum
     * @throws PeriodRateException                  падает при непонятном периоде
     * @throws AlgorithmNotExistException           падает при непонятном алгоритме
     * @throws OutputIsNotExistException            падает при непонятном output
     */
    public void validCmdCommandRate(@NonNull CommandLine cmd) {
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
        if (!cmd.hasOption("date") && !cmd.hasOption("period")) {
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
        if (cmd.hasOption("output")) {
            if (!EnumUtils.isValidEnumIgnoreCase(OutputCommandType.class, cmd.getOptionValue("output"))) {
                throw new OutputIsNotExistException();
            }
        }
    }
}
