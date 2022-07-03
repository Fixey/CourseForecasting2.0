package ru.liga.front;

import ru.liga.exception.UnknownCommandException;

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
    public IOutputRateCommander getOutput(String output) {
        switch (output) {
            case ("list"):
                return new OutputList();
            case ("graph"):
                return new OutputGraph();
            default:
                throw new UnknownCommandException();
        }
    }
}
