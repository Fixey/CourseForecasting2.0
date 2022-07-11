package ru.liga.fat.csvfile;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.command.exception.CurrencyRateException;
import ru.liga.fat.csvfile.exception.AverageIndexOutException;
import ru.liga.fat.entity.ExchangeRates;
import ru.liga.fat.enums.CurrencyType;
import ru.liga.fat.csvfile.exception.FailReadFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.liga.fat.constant.ConstantUtil.CURRENCY_MAP;

/**
 * Собирает все документы в одну библиотеку
 */
@Slf4j
public class Configurations {
    private static Configurations _instance = null;
    private List<ExchangeRates> listExchangeRatesFromFile = new LinkedList<>();

    public Configurations() {
    }

    /**
     * Инициализация
     *
     * @return Configurations
     * @throws FailReadFile ошибка в чтении файла
     */
    public synchronized static Configurations init() {
        if (_instance == null) {
            log.info("Reads files");
            _instance = new Configurations();
            _instance.listExchangeRatesFromFile = new LinkedList<>();
            try {
                for (CurrencyType currency : CurrencyType.values()) {
                    FileReader fileReader = new FileReader();
                    List<String> listLines = fileReader.getListLinesFromFile("/csv/" + currency.name() + ".csv");
                    _instance.listExchangeRatesFromFile.addAll(_instance.getExchangeRatesList(listLines));
                }
                log.info("Read files successfully");
            } catch (Exception e) {
                log.error("Configurations: " + e.getMessage(), e);
                throw new FailReadFile();
            }
        }
        return _instance;
    }

    /**
     * Возвращает список курсов
     *
     * @return List<ExchangeRates> список курсов
     * @throws CurrencyRateException ошикбка если курса не существует
     * @throws AverageIndexOutException ощибка при парсинге значения курса
     */
    public List<ExchangeRates> getListExchangeRatesFromFile() {
        return _instance.listExchangeRatesFromFile;
    }

    private List<ExchangeRates> getExchangeRatesList(List<String> listLines) {
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