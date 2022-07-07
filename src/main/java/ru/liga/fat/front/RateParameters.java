package ru.liga.fat.front;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.enums.AlgorithmType;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.enums.OutputCommandType;
import ru.liga.fat.exception.ConsoleArgsException;
import ru.liga.fat.exception.CountDaysException;
import ru.liga.fat.util.PeriodUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class RateParameters implements CommandParameters {
    public CommandsType command;
    public OutputCommandType output;
    public LocalDate date;
    public Integer period;
    public List<CurrencyType> currencies;
    public AlgorithmType algorithmType;
    /**
     * Сохраняем чтобы различить что за команда Дата или Период
     */
    public String typeCommandDate;
    public Map<String, Object> mapParameters = new HashMap<>();

    /**
     * Инициализирует параметры для команды Rate
     *
     * @param fullCommand команда
     */
    public void initParams(String fullCommand) {
        try {
            final String[] arrParams = fullCommand.trim().split("\\s+");
            this.command = EnumUtils.getEnumIgnoreCase(CommandsType.class, arrParams[0]);
            if (this.command == null) {
                throw new ConsoleArgsException();
            }
            CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
            log.debug("Start command `validation`");
            new CommandRateValidation().validCmdCommandRate(cmd);//Проверим корректное написание команды
            //Валидация
            log.debug("Validation was successes");
            //Декларация переменных
            this.currencies = Arrays.stream(cmd.getArgs()[1].split(",")).map(x -> EnumUtils.getEnumIgnoreCase(CurrencyType.class, x)).collect(Collectors.toList());
            if (cmd.hasOption("date")) {
                this.typeCommandDate = "date";
            } else this.typeCommandDate = "period";

            if (cmd.hasOption("date")) {
                this.date = PeriodUtils.toLocalDateTimeFromPeriod(cmd.getOptionValue("date"));
            }
            if (cmd.hasOption("period")) {
                Integer numDays = PeriodUtils.countDayForPeriod(cmd.getOptionValue("period"));
                if (numDays == null) {
                    throw new CountDaysException();
                }
                this.period = numDays;
            }
            this.algorithmType = EnumUtils.getEnumIgnoreCase(AlgorithmType.class, cmd.getOptionValue("alg"));
            this.output = EnumUtils.getEnumIgnoreCase(OutputCommandType.class, cmd.getOptionValue("output"));
            log.debug("RateParameters = " + this);
            getParameters();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            log.error(e.getMessage(), e);
            throw new ConsoleArgsException();
        }
    }

    /**
     * Вернуть параметры в виде мапы
     *
     * @return Map<String, Object> Мапа<Флаг,Значение></> объектов команды
     */
    public Map<String, Object> getParameters() {
        mapParameters.put("command", command);
        mapParameters.put("output", output);
        mapParameters.put("date", date);
        mapParameters.put("period", period);
        mapParameters.put("currencies", currencies);
        mapParameters.put("algorithmType", algorithmType);
        mapParameters.put("typeCommandDate", typeCommandDate);
        return mapParameters;
    }
}
