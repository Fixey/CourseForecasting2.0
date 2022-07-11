package ru.liga.fat.command;

import lombok.Data;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.enums.CommandsType;
import ru.liga.fat.enums.OutputCommandType;

import java.util.HashMap;
import java.util.Map;

@Data
public class HelpParameters implements CommandParameters {
    final private CommandsType command;
    private Map<String, Object> mapParameters = new HashMap<>();

    /**
     * Инициализация парамтеров
     *
     * @param command название команды
     */
    public HelpParameters(String command) {
        this.command = EnumUtils.getEnumIgnoreCase(CommandsType.class, command.trim());
        getMepOfParameters();
    }

    @Override
    public OutputCommandType getOutputCommandType() {
        return null;
    }

    /**
     * Вернуть параметры в виде мапы
     *
     * @return Map<String, Object> Мапа<Флаг,Значение></> объектов команды
     */
    @Override
    public Map<String, Object> getMepOfParameters() {
        mapParameters.put("help", this.command);
        return mapParameters;
    }
}
