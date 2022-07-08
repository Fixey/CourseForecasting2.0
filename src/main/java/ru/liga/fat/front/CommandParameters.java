package ru.liga.fat.front;

import ru.liga.fat.enums.CommandsType;

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

    CommandsType getCommand();

    /**
     * Вернуть параметры в виде мапы
     *
     * @return Map<String, Object> Мапа<Флаг,Значение></> объектов команды
     */
    Map<String, Object> getMepOfParameters();
}
