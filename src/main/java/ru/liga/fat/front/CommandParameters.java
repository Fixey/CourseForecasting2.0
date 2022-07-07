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

    Map<String, Object> getMapParameters();

    CommandsType getCommand();

    /**
     * Инициализация парамтеров
     *
     * @param command название команды
     */
    void initParams(String command);

    /**
     * Вернуть параметры в виде мапы
     *
     * @return Map<String, Object> Мапа<Флаг,Значение></> объектов команды
     */
    Map<String, Object> getParameters();
}
