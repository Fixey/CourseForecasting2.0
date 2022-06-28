package ru.liga.util;

import lombok.NonNull;
import org.apache.commons.lang3.EnumUtils;
import ru.liga.enums.Period;
import ru.liga.exception.CountDaysException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

import static ru.liga.constant.ConstantUtil.DATE_TIME_FORMATTER;

public class PeriodUtils {

    /**
     * Рассчет кол-ва дней с текущего дня до определнное даты
     *
     * @param date дата в формате dd/MM/yyyy
     * @return Integer кол-во дней с сегодняшнего дня до определнное даты
     */
    public static Integer countDaysUntilDate(@NonNull String date) {
        try {
            if (date.matches("(\\d{2})/(\\d{2})/(\\d{4})")) {
                final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
        if (days == 0) { //Для текущего дня
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
        if (period.matches("(\\d{2})/(\\d{2})/(\\d{4})")) {
            return countDaysUntilDate(period);
        } else if (EnumUtils.isValidEnumIgnoreCase(Period.class, period)) {
            return EnumUtils.getEnumIgnoreCase(Period.class, period).getNumDays();
        }
        return null;
    }

    public static LocalDate toLocalDateTimeFromString(String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }
}
