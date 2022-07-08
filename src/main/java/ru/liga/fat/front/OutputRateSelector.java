package ru.liga.fat.front;

import ru.liga.fat.enums.OutputCommandType;
import ru.liga.fat.exception.UnknownCommandException;

/**
 * Выбор обработки output
 */
public class OutputRateSelector {
    /**
     * Выбрать как обработать output
     *
     * @param commandParameters параметры команды
     * @return IOutputRateCommander класс в котором будет выполняться обработка
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
        throw new UnknownCommandException();
    }
}
