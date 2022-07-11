package ru.liga.fat.csvfile;

import lombok.NonNull;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.fat.command.exception.CountDaysException;
import ru.liga.fat.enums.Period;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

import static ru.liga.fat.constant.ConstantUtil.DATE_REGEX;
import static ru.liga.fat.constant.ConstantUtil.DATE_TIME_FORMATTER;

public class PeriodUtils {
    /**
     * Рассчет кол-ва дней с текущего дня до определнное даты
     *
     * @param date дата в формате dd/MM/yyyy
     * @return Integer кол-во дней с сегодняшнего дня до определнное даты
     * @throws CountDaysException падает когда не может посчитать дни
     */
    public static Integer countDaysUntilDate(@NonNull String date) {
        try {
            if (date.matches(DATE_REGEX)) {
                final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                final LocalDate date1 = LocalDate.now();
                final LocalDate date2 = LocalDate.parse(date, dtf);
                return (int) ChronoUnit.DAYS.between(date1, date2);
            }
            return null;
        } catch (DateTimeParseException e) {
            throw new CountDaysException();
        }

    }

    /**
     * Рассчет кол-ва дней с текущего дня до определнное даты
     *
     * @param date дата
     * @return Integer кол-во дней с сегодняшнего дня до определнное даты
     */
    public static Integer countDaysUntilDate(@NonNull LocalDate date) {
        final LocalDate today = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(today, date);
    }

    /**
     * Возвращает лист дат за n дней относительно текущего дня
     *
     * @param days кол-во дней
     * @return Integer кол-во дней с сегодняшнего дня до определнное даты
     */
    public static LinkedList<String> getListOfDatesForPeriod(@NonNull Integer days) {
        final LocalDateTime today = LocalDateTime.now();
        LinkedList<String> listDates = new LinkedList<>();
        String strData;
        if (days == 0) {
            strData = DATE_TIME_FORMATTER.format(today);
            listDates.add(Character.toUpperCase(strData.charAt(0)) + strData.substring(1) + " - ");
            return listDates;
        }
        for (int i = 1; i <= days; i++) {
            LocalDateTime nextDay = today.plusDays(i);
            strData = DATE_TIME_FORMATTER.format(nextDay);
            listDates.add(Character.toUpperCase(strData.charAt(0)) + strData.substring(1) + " - ");
        }
        return listDates;
    }

    /**
     * Рассчет кол-ва дней за указанный период
     *
     * @param period период
     * @return Integer кол-во дней до периода
     */
    public static Integer countDayForPeriod(@NonNull String period) {
        if (period.matches(DATE_REGEX)) {
            return countDaysUntilDate(period);
        } else if (EnumUtils.isValidEnumIgnoreCase(Period.class, period)) {
            return EnumUtils.getEnumIgnoreCase(Period.class, period).getNumDays();
        }
        return null;
    }

    /**
     * Переводит дату из String в LocalDate
     *
     * @param date Дата
     * @return LocalDate Дата
     */
    public static LocalDate toLocalDateTimeFromString(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

    /**
     * Перевод в дату из названия периода в LocalDate
     *
     * @param period период
     * @return LocalDate дата
     */
    public static LocalDate toLocalDateTimeFromPeriod(String period) {
        LocalDate resultDate = null;
        if (period.matches(DATE_REGEX)) {
            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            resultDate = LocalDate.parse(period, dtf);
        } else if (EnumUtils.isValidEnumIgnoreCase(Period.class, period)) {
            final int numDays = EnumUtils.getEnumIgnoreCase(Period.class, period).getNumDays();
            resultDate = LocalDate.now().plusDays(numDays);
        }
        return resultDate;
    }
}
