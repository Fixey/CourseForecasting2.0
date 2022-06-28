package ru.liga;

import org.junit.Test;
import ru.liga.util.PeriodUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class PeriodUtilsTest {
    @Test
    public void countDaysUntilDateWithoutExceptions() {
        PeriodUtils periodUtils = new PeriodUtils();
        LocalDate date2 = LocalDate.now().plusDays(2);
        LocalDate date3 = LocalDate.now().minusDays(2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertNotNull(periodUtils.countDaysUntilDate("21/06/2022"));
        assertTrue(periodUtils.countDaysUntilDate(date2.format(dtf)).equals(2));
        assertTrue(periodUtils.countDaysUntilDate(date3.format(dtf)).equals(-2));
        assertNull(periodUtils.countDaysUntilDate("21-06-2022"));
    }

    @Test
    public void getNullDaysUntilDateTest() {
        PeriodUtils periodUtils = new PeriodUtils();
        assertNull(periodUtils.countDaysUntilDate("21-06-2022"));
    }

    @Test
    public void countDayForPeriodWithoutExceptions() {
        PeriodUtils periodUtils = new PeriodUtils();
        LocalDate date2 = LocalDate.now().plusDays(2);
        LocalDate date3 = LocalDate.now().plusDays(10);
        LocalDate today = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertTrue(periodUtils.countDayForPeriod(date2.format(dtf)).equals(2));
        assertTrue(periodUtils.countDayForPeriod(date3.format(dtf)).equals(10));
        assertTrue(periodUtils.countDayForPeriod(today.format(dtf)).equals(0));
        assertTrue(periodUtils.countDayForPeriod("Today").equals(0));
        assertTrue(periodUtils.countDayForPeriod("Tomorrow").equals(1));
        assertTrue(periodUtils.countDayForPeriod("Week").equals(7));

    }

    @Test
    public void getNullCountDayForPeriod() {
        PeriodUtils periodUtils = new PeriodUtils();
        assertNull(periodUtils.countDayForPeriod("WTF"));
        assertNull(periodUtils.countDayForPeriod("22.05.2222"));
    }

    @Test
    public void getNullListOfDatesForPeriod() {
        PeriodUtils periodUtils = new PeriodUtils();
//        assertNull(periodEngine.getListOfDatesForPeriod(1));
//        assertNull(periodEngine.getListOfDatesForPeriod(0));
    }

    @Test
    public void getListOfDatesForPeriodWithoutExceptions() {
        PeriodUtils periodUtils = new PeriodUtils();
        assertTrue(periodUtils.getListOfDatesForPeriod(1).size() == 1);
        assertTrue(periodUtils.getListOfDatesForPeriod(0).size() == 1);
        assertTrue(periodUtils.getListOfDatesForPeriod(10).size() == 10);
    }


}
