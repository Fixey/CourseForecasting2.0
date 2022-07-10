package ru.liga.fat.tech;

import ru.liga.fat.tech.enums.CommandsType;
import ru.liga.fat.tech.enums.OutputCommandType;

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
