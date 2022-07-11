package ru.liga.fat.output;

import ru.liga.fat.command.CommandParameters;
import ru.liga.fat.command.exception.OutputIsNotExistException;
import ru.liga.fat.enums.OutputCommandType;

/**
 * Выбор обработки output
 */
public class OutputRateSelector {
    /**
     * Выбрать как обработать output
     *
     * @param commandParameters параметры команды
     * @return IOutputRateCommander класс в котором будет выполняться обработка
     * @throws OutputIsNotExistException ошибка если не существует такого output
     */
    public IOutputRateCommander getOutput(CommandParameters commandParameters) {
        final var commandOutput = commandParameters.getOutputCommandType();
        if (commandOutput == null) {
            return new OutputList();
        }
        OutputCommandType output = commandOutput;
        switch (output) {
            case list:
                return new OutputList();
            case graph:
                return new OutputGraph();
        }
        throw new OutputIsNotExistException();
    }
}
