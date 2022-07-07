package ru.liga.fat.front;

import lombok.Data;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.enums.CommandsType;

import java.util.HashMap;
import java.util.Map;

@Data
public class HelpParameters implements CommandParameters {
    public CommandsType command;
    public Map<String, Object> mapParameters = new HashMap<>();

    /**
     * Инициализация парамтеров
     *
     * @param command название команды
     */
    @Override
    public void initParams(String command) {
        this.command = EnumUtils.getEnumIgnoreCase(CommandsType.class, command.trim());
        getParameters();
    }

    /**
     * Вернуть параметры в виде мапы
     *
     * @return Map<String, Object> Мапа<Флаг,Значение></> объектов команды
     */
    @Override
    public Map<String, Object> getParameters() {
        mapParameters.put("help", this.command);
        return mapParameters;
    }
}
