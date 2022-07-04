package ru.liga.back;

import lombok.extern.slf4j.Slf4j;
import ru.liga.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Алгоритм рассчета "Прошлогодний"
 */
@Slf4j
public class AlgorithmMoonForecasting implements IRateAlgorithm {
    private List<ExchangeRates> exchangeRatesFromFiles;

    public AlgorithmMoonForecasting(List<ExchangeRates> exchangeRatesFromFiles) {
        this.exchangeRatesFromFiles = exchangeRatesFromFiles;
    }

    /**
     * Алгоритм “Прошлогодний”.
     * Берёте курс за эту дату за прошлый год и показываете. Если на дату нет курса, то за предыдущие дни.
     * Формирует лист Курса Валют на n дней
     *
     * @param currency Валюта
     * @param period   на сколько дней рассчитывать
     * @return LinkedList<ExchangeRates> лист Курса валют
     */
    public LinkedList<ExchangeRates> getListExchangeRates(CurrencyType currency, Integer period) {
        log.debug("AlgorithmMoonForecasting.getListExchangeRates().args:");
        log.debug("currency = " + currency.name());
        log.debug("period = " + period);
        LinkedList<ExchangeRates> listExchangeRatesRes = new LinkedList<>();
        for (int i = 1; i <= period; i++) {
            listExchangeRatesRes.addAll(getListExchangeRates(currency, LocalDate.now().plusDays(i)));
        }
        return listExchangeRatesRes;
    }

    /**
     * Алгоритм “Прошлогодний”.
     * Берёте курс за эту дату за прошлый год и показываете. Если на дату нет курса, то за предыдущие дни.
     * Формирует лист Курса Валют на n дней
     *
     * @param currency Валюта
     * @param date     на какой день рассчитывать
     * @return LinkedList<ExchangeRates> лист Курса валют
     */
    @Override
    public LinkedList<ExchangeRates> getListExchangeRates(CurrencyType currency, LocalDate date) {
        log.debug("AlgorithmMoonForecasting.getListExchangeRates().args:");
        log.debug("currency = " + currency.name());
        log.debug("date = " + date);
        BigDecimal rate = exchangeRatesFromFiles.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency() == currency)
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .filter((x) -> x.getDate().compareTo(date.minusYears(1)) <= 0)
                .findFirst().map(ExchangeRates::getRate).get();
        LinkedList<ExchangeRates> listExchangeRatesRes = new LinkedList<>();
        listExchangeRatesRes.add(new ExchangeRates(currency, rate, date));
        System.out.println("Алгоритм рассчитан");
        return listExchangeRatesRes;
    }
}