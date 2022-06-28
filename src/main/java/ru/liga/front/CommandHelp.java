package ru.liga.front;

import java.util.LinkedList;

/**
 * Класс отвечающий за действия по команде Help
 */
public class CommandHelp implements Command {

    /**
     * Распечатывает список команд прогарммы
     */
    @Override
    public void invoke(LinkedList<String> listArgs) {
        System.out.println("Options:");
        System.out.println("Rate <eur, usd, try> <today, tomorrow, week, month, dd/MM/yyyy>         Print Rate during period");
        System.out.println("help                                                                    Print commands for this app");
        System.out.println("exit                                                                    Exit from app");
    }
}
