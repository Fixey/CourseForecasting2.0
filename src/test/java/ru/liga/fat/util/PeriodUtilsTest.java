package ru.liga.fat.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PeriodUtilsTest {
    private LocalDate date;
    private LocalDate date2;
    public PeriodUtilsTest(){
        this.date = LocalDate.now().plusDays(2);
        this.date = LocalDate.now().minusDays(2);

    }

    @Test
    public void countDaysUntilDateWithoutExceptions() {
        PeriodUtils periodUtils = new PeriodUtils();
        LocalDate date = LocalDate.now().plusDays(2);
        LocalDate date2 = LocalDate.now().minusDays(2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertNotNull(periodUtils.countDaysUntilDate("21/06/2022"));
        assertTrue(periodUtils.countDaysUntilDate(date.format(dtf)).equals(2));
        assertTrue(periodUtils.countDaysUntilDate(date2.format(dtf)).equals(-2));
        assertNull(periodUtils.countDaysUntilDate("21-06-2022"));
    }

    @Test
    void testCountDaysUntilDate() {
    }

    @Test
    void getListOfDatesForPeriod() {
    }

    @Test
    void countDayForPeriod() {
    }

    @Test
    void toLocalDateTimeFromString() {
    }

    @Test
    void toLocalDateTimeFromPeriod() {
    }
}