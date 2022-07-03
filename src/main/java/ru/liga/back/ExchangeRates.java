package ru.liga.back;

import lombok.Data;
import ru.liga.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;

import static ru.liga.constant.ConstantUtil.DATE_TIME_FORMATTER;

/**
 * Объект Курс Валют
 */
@Data
public class ExchangeRates {

    public LocalDate date;
    public BigDecimal rate;
    public CurrencyType currency;

    public ExchangeRates(CurrencyType currency, BigDecimal rate, LocalDate date) {
        this.currency = currency;
        this.rate = rate;
        this.date = date;
    }

    /**
     * Формирование даты и курса в виде "Вт 22.02.2022 - 75,45"
     *
     * @return String
     */
    public String getInfo() {
        final String srtDate = DATE_TIME_FORMATTER.format(date);

        return Character.toUpperCase(srtDate.charAt(0)) + srtDate.substring(1) + " - "
                + String.format("%.2f", rate);
    }
}
