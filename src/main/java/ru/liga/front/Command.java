package ru.liga.front;

import java.util.List;

/**
 * Интрефейс Метода команды
 */
interface Command {
    /**
     * @param fullCommand полная команда
     */
    List invoke(String fullCommand);
}