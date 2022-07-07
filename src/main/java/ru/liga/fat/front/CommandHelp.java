package ru.liga.fat.front;


import ru.liga.fat.back.RatesPrediction;

import java.util.LinkedList;

/**
 * Класс отвечающий за действия по команде Help
 */
public class CommandHelp implements Command {

    /**
     * Распечатывает список команд прогарммы
     *
     * @param commandParameters полная команда
     * @return List<List < ExchangeRates>> списки курсов
     */
    @Override
    public RatesPrediction invoke(CommandParameters commandParameters) {
        LinkedList listCommands = new LinkedList();
        listCommands.add("Options:");
        listCommands.add("Rate <eur, usd, try> <today, tomorrow, week, month, dd/MM/yyyy>         Print Rate during period");
        listCommands.add("help                                                                  Print commands for this app");
        listCommands.add("exit                                                                    Exit from app");
        return null;
    }
}
