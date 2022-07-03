package ru.liga.back;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.enums.CurrencyType;
import ru.liga.exception.AverageIndexOutException;
import ru.liga.exception.CurrencyRateException;
import ru.liga.exception.FailReadFile;
import ru.liga.util.FileReader;
import ru.liga.util.PeriodUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

import static ru.liga.constant.ConstantUtil.CURRENCY_MAP;

/**
 * Собирает все документы в одну библиотеку
 */
@Slf4j
public class Configurations {
    private static Configurations _instance = null;
    public static LinkedList<ExchangeRates> LIST_EXCHANGE_RATES = new LinkedList<>();

    public Configurations() {
        log.info("Reads files");
        LIST_EXCHANGE_RATES = new LinkedList<ExchangeRates>();
        try {
            for (CurrencyType currency : CurrencyType.values()) {
                FileReader fileReader = new FileReader();
                LinkedList<String> listLines = fileReader.getListLinesFromFile("/csv/" + currency.name() + ".csv");
                LIST_EXCHANGE_RATES.addAll(getExchangeRatesList(listLines));
            }
            log.info("Read files successfully");
        } catch (Exception e) {
            log.error("Configurations: " + e.getMessage());
            throw new FailReadFile();
        }
    }

    public synchronized static Configurations getInstance() {
        if (_instance == null)
            _instance = new Configurations();
        return _instance;
    }

    // получить значение свойства по имени
    public synchronized LinkedList<ExchangeRates> getExchangeRatesList() {
        return (LinkedList<ExchangeRates>) LIST_EXCHANGE_RATES.clone();
    }

    private LinkedList<ExchangeRates> getExchangeRatesList(LinkedList<String> listLines) {
        try {
            LinkedList<ExchangeRates> listExchangeRates = new LinkedList<>();
            for (int i = 1; i < listLines.size(); i++) {
                String line = listLines.get(i);
                String[] argsLine = line.trim().split(";");
                LocalDate localDate = PeriodUtils.toLocalDateTimeFromString(argsLine[1]);
                String rate = argsLine[2];
                String currency = argsLine[3];
                HashMap<String, String> aliasCurrency = new HashMap<>(CURRENCY_MAP);
                if (!aliasCurrency.containsKey(currency)) {
                    throw new CurrencyRateException(currency);
                }
                String currencyName = aliasCurrency.get(currency);
                BigDecimal bigDecimalRate = BigDecimal.valueOf(Double.parseDouble(rate.trim().substring(0, rate.length() - 1).replace(",", ".")));

                listExchangeRates.add(new ExchangeRates(EnumUtils.getEnumIgnoreCase(CurrencyType.class, currencyName), bigDecimalRate, localDate));
            }
            return listExchangeRates;
        } catch (IndexOutOfBoundsException e) {
            throw new AverageIndexOutException();
        }
    }
}