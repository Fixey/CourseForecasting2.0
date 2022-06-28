package ru.liga.front;

import java.util.LinkedList;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param listArgs аргументы метода
     */
    void invoke(LinkedList<String> listArgs);
}