package ru.liga.util;

import lombok.NonNull;
import ru.liga.back.ExchangeRates;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

/**
 * Рассчитывает стреднее арифмитическое
 */
public class AverageRate {
    /**
     * Рассчитывает стреднее арифмитическое значение из листа курса
     *
     * @param listRates лист из ставок курса
     * @return BigDecimal Среднее арифмитическое курса
     */
    public BigDecimal getAverageRate(@NonNull LinkedList<BigDecimal> listRates) {
        if (listRates.size() == 0) {
            return null;
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getAverageRateForExchangeRates(@NonNull LinkedList<ExchangeRates> listRates) {
        if (listRates.size() == 0) {
            return null;
        }
        BigDecimal sum = BigDecimal.ZERO;
        int count = 0;
        for (ExchangeRates exchangeRates : listRates) {
            BigDecimal rate = exchangeRates.getRate();
            if (null != rate) {
                sum = sum.add(rate);
                count++;
            }
        }
        return sum.divide(new BigDecimal(count), RoundingMode.CEILING);
    }
}
