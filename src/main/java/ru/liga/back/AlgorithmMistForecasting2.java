package ru.liga.back;

import ru.liga.enums.CurrencyType;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static ru.liga.back.Configurations.LIST_EXCHANGE_RATES;

/**
 * Алгоритм рассчета "Мистический"
 */
public class AlgorithmMistForecasting2 implements IRateAlgorithm {
    private LinkedList<ExchangeRates> listExchangeRates = new LinkedList<>();

    /**
     * Алгоритм “Мистический”.
     * Для каждого следующего дня берёте рандомно один из 30 предыдущих дней включая рассчитанные таким образом.
     *
     * @param currency Валюта
     * @param period   на сколько дней рассчитывать
     * @return LinkedList<ExchangeRates> лист Курса валют
     */
    @Override
    public LinkedList<ExchangeRates> getListExchangeRates(CurrencyType currency, Integer period) {
        LinkedList<ExchangeRates> exchangeRatesList = new LinkedList<>();
        for (int i = 0; i < period; i++) {
            exchangeRatesList.addAll(getListExchangeRates(currency, LocalDate.now().plusDays(period)));
        }
        return exchangeRatesList;
    }


    /**
     * Алгоритм “Мистический”.
     * Для каждого следующего дня берёте рандомно один из 30 предыдущих дней включая рассчитанные таким образом.
     *
     * @param currency Валюта
     * @param date     на какой день рассчитывать
     * @return LinkedList<ExchangeRates> лист Курса валют
     */
    @Override
    public LinkedList<ExchangeRates> getListExchangeRates(CurrencyType currency, LocalDate date) {
        if (listExchangeRates.isEmpty()) {
            fillDefaultListExchangeRates(currency);
        }
        System.out.println("____");
        System.out.println(listExchangeRates);
        System.out.println("_____");
        calcListExchangeRatesOnAlg2(currency, date);
        LinkedList<ExchangeRates> listExchangeRatesRes = new LinkedList<>();
        listExchangeRatesRes.add(listExchangeRates.get(listExchangeRates.size() - 1));
        return listExchangeRatesRes;
    }

    /**
     * Заполнение преддефолтной информации
     *
     * @param currency тип валюты
     */
    private void fillDefaultListExchangeRates(CurrencyType currency) {
        listExchangeRates = LIST_EXCHANGE_RATES.stream()
                .filter(exchangeRates -> exchangeRates.getCurrency().equals(currency))
                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
                .limit(30)
                .collect(Collectors.toCollection(LinkedList::new));
        LocalDate lastDateInFile = listExchangeRates.get(0).getDate();
        calcListExchangeRatesOnAlg(currency, lastDateInFile);

    }
    private void calcListExchangeRatesOnAlg(CurrencyType currency, LocalDate date) {
        final int numDaysUntilDates = (int) Math.abs(DAYS.between(LocalDate.now(), date));
        LocalDate lastDateLineExchangeRate = listExchangeRates.getFirst().getDate().plusDays(1);
        for (int i = 0; i < numDaysUntilDates; i++) {
            var random = new SecureRandom();

            BigDecimal rate = listExchangeRates.get(random.nextInt(listExchangeRates.size()))
                    .getRate();
            listExchangeRates.pollLast();
            listExchangeRates.offerFirst(new ExchangeRates(currency, rate, lastDateLineExchangeRate.plusDays(i)));
        }
    }
    private void calcListExchangeRatesOnAlg2(CurrencyType currency, LocalDate date) {
        final int numDaysUntilDates = (int) Math.abs(DAYS.between(LocalDate.now(), date));
        LocalDate lastDateLintExchangeRate = listExchangeRates.getFirst().getDate();
        for (int i = 0; i < numDaysUntilDates; i++) {
            var random = new SecureRandom();

            BigDecimal rate = listExchangeRates.get(random.nextInt(listExchangeRates.size()))
                    .getRate();
            listExchangeRates.pollLast();
            listExchangeRates.offerFirst(new ExchangeRates(currency, rate, lastDateLintExchangeRate.plusDays(i)));
        }
    }
}
