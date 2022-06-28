package ru.liga.constant;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ConstantUtil {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("EE dd.MM.yyyy");
public static final Map CURRENCY_MAP = Map.of("Турецкая лира", "TRY",
        "Евро", "EUR",
        "Доллар США", "USD",
        "Болгарский лев", "BGN",
        "Армянский драм","AMD");
}
