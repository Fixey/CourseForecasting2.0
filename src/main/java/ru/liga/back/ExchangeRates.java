package ru.liga.back;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

import static ru.liga.constant.ConstantUtil.DATE_TIME_FORMATTER;

/**
 * Объект Курс Валют
 */
@Data
public class ExchangeRates {

    public LocalDate date = null;
    public BigDecimal rate = BigDecimal.ZERO;
    public String currency = "";

    ExchangeRates() {

    }

    ExchangeRates(BigDecimal rate) {
        this.rate = rate;
        this.date = LocalDate.now();
    }

    ExchangeRates(BigDecimal rate, LocalDate date) {
        this.rate = rate;
        this.date = date;
    }

    ExchangeRates(String currency, BigDecimal rate, LocalDate date) {
        this.currency = currency;
        this.rate = rate;
        this.date = date;
    }

    /**
     * Формирование даты и курса в виде "Вт 22.02.2022 - 75,45"
     *
     * @return String
     */
    public String getDateAndRate() {
        final String srtDate = DATE_TIME_FORMATTER.format(date);

        String dateAndRateResult = Character.toUpperCase(srtDate.charAt(0)) + srtDate.substring(1) + " - "
                + String.format("%.2f", rate);

        return dateAndRateResult;
    }
}
