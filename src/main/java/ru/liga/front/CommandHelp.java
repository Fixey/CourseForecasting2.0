package ru.liga.front;


import java.util.LinkedList;
import java.util.List;

/**
 * Класс отвечающий за действия по команде Help
 */
public class CommandHelp implements Command {

    /**
     * Распечатывает список команд прогарммы
     */
    @Override
    public List invoke(String listArgs) {
        List<String> listCommands = new LinkedList();
        listCommands.add("Options:");
        listCommands.add("Rate <eur, usd, try> <today, tomorrow, week, month, dd/MM/yyyy>         Print Rate during period");
        listCommands.add("help                                                                  Print commands for this app");
        listCommands.add("exit                                                                    Exit from app");
        return listCommands;
    }
}
