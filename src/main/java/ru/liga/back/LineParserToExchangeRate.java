package ru.liga.back;

import ru.liga.exception.AverageIndexOutException;
import ru.liga.exception.CurrencyRateException;
import ru.liga.util.PeriodUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LineParserToExchangeRate {
    /**
     * Распарсить список CSV строк и возвращает Лист объектов Курса Валют
     *
     * @param listLines список строк и CSV
     * @param numLines  кол-во строк, которых надо преобразовать
     * @return LinkedList<ExchangeRates> Лист объектов Курса Валют
     * @throws CurrencyRateException    падает при ошибке в названии курсе
     * @throws AverageIndexOutException падает, если не код не смог рассчитать среднюю арифметическую
     */
    public LinkedList<ExchangeRates> getListExchangeRates(LinkedList<String> listLines, int numLines) {
        try {
            LinkedList<ExchangeRates> listExchangeRates = new LinkedList<>();
            for (int i = 1; i <= numLines && i < listLines.size(); i++) {
                String line = listLines.get(i);
                String[] argsLine = line.trim().split(";");
                LocalDate localDate = PeriodUtils.toLocalDateTimeFromString(argsLine[1]);
                String rate = argsLine[2];
                String currency = argsLine[3];
                HashMap<String, String> aliasCurrency = new HashMap<>(Map.of("Турецкая лира", "TRY",
                        "Евро", "EUR",
                        "Доллар США", "USD"));
                if (!aliasCurrency.containsKey(currency)) {
                    throw new CurrencyRateException();
                }
                String currencyName = aliasCurrency.get(currency);
                BigDecimal bigDecimalRate = BigDecimal.valueOf(Double.parseDouble(rate.substring(2, rate.length() - 1).replace(",", ".")));

                listExchangeRates.add(new ExchangeRates(currencyName, bigDecimalRate, localDate));
                if (i == numLines) {
                    return listExchangeRates;
                }
            }
            return listExchangeRates;
        } catch (IndexOutOfBoundsException e) {
            throw new AverageIndexOutException();
        }
    }
}
