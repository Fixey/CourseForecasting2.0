package ru.liga.fat.front;

import ru.liga.fat.enums.OutputCommandType;
import ru.liga.fat.exception.UnknownCommandException;

/**
 * Выбор обработки output
 */
public class OutputSelector {
    /**
     * Выбрать как обработать output
     *
     * @param output название output
     * @return IOutputRateCommander класс в котором будет выполняться обработка
     */
    public IOutputRateCommander getOutput(OutputCommandType output) {
        switch (output) {
            case list:
                return new OutputList();
            case graph:
                return new OutputGraph();
        }
        throw new UnknownCommandException();
    }
}
