package ru.liga.fat.tech.constant;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConstantUtil {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("EE dd.MM.yyyy");
    public static final Map<String, String> CURRENCY_MAP = Map.of("Турецкая лира", "TRY",
            "Евро", "EUR",
            "Доллар США", "USD",
            "Болгарский лев", "BGN",
            "Армянский драм", "AMD");
    public static final String DATE_REGEX = "(\\d{2}).(\\d{2}).(\\d{4})";
    public static final Integer FORECASTING_MIST_NUM = 30;
    public static final Integer FORECASTING_WEB_NUM = 30;
    public static final String GRAPH_PATH = "graph.png";
    public static final ArrayList<String> COLOR_DICT = new ArrayList<>(List.of("blue", "red", "black",
            "green", "purple", "pink", "yellow"));
}
