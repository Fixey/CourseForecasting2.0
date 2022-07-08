package ru.liga.fat.back;

import lombok.Data;
import ru.liga.fat.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDate;

import static ru.liga.fat.constant.ConstantUtil.DATE_TIME_FORMATTER;

/**
 * Объект Курс Валют
 */
@Data
final public class ExchangeRates {

    final private LocalDate date;
    final private BigDecimal rate;
    final private CurrencyType currency;

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
