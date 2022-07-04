package ru.liga.fat.front;

import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.Test;
import ru.liga.fat.exception.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandRateValidationTest {
    /**
     * * @throws CurrencyRateException                падает при непонятном курсе
     * * @throws PeriodRequiredInRateCommandException падает при присутствии периода без отпут флага
     * * @throws PeriodOrDateRequiredException        падает при отсутствии периода или даты
     * * @throws DateRateException                    падает при отсутствии даты в enum
     * * @throws PeriodRateException                  падает при непонятном периоде
     * * @throws AlgorithmNotExistException           падает при непонятном алгоритме
     * * @throws OutputIsNotExistException            падает при непонятном output
     */
    @Test
    void getOutputIsNotExistException() {
        String fullCommand = "rate usd -period week -alg mist -output wtf";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(OutputIsNotExistException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
    @Test
    void getAlgorithmNotExistException() {
        String fullCommand = "rate usd -period week -alg wtf -output list";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(AlgorithmNotExistException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
    @Test
    void getPeriodRateException() {
        String fullCommand = "rate usd -period wtf -alg mist -output list";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(PeriodRateException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
    @Test
    void getDateRateException() {
        String fullCommand = "rate usd -date wtf -alg mist -output list";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(DateRateException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
    @Test
    void getPeriodOrDateRequiredException() {
        String fullCommand = "rate usd -alg mist -output list";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(PeriodOrDateRequiredException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
    @Test
    void getPeriodRequiredInRateCommandException() {
        String fullCommand = "rate usd -period week -alg mist";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(PeriodRequiredInRateCommandException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
    @Test
    void getCurrencyRateException() {
        String fullCommand = "rate use -alg mist";
        CommandLine cmd = new FormerConsoleArguments().getCommandLineFromCommand(fullCommand);
        CommandRateValidation commandRateValidation = new CommandRateValidation();
        assertThrows(CurrencyRateException.class, () -> {
            commandRateValidation.ValidCmdCommandRate(cmd);
        });
    }
}