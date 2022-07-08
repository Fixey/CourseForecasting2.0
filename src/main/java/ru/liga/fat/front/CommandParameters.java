package ru.liga.fat.front;

import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.enums.OutputCommandType;

import java.util.HashMap;
import java.util.Map;

/**
 * Распарсивание параметров команды
 */
public interface CommandParameters {
    /**
     * Название команды
     */
    CommandsType command = null;
    /**
     * Все параметры
     */
    Map<String, Object> mapParameters = new HashMap<>();

    /**
     * Название команды
     * @return CommandsType команда
     */
    CommandsType getCommand();

    /**
     * Output
     * @return вернуть
     */
    OutputCommandType getOutputCommandType();
    /**
     * Вернуть параметры в виде мапы
     *
     * @return Map<String, Object> Мапа<Флаг,Значение></> объектов команды
     */
    Map<String, Object> getMepOfParameters();
}
