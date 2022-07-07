package ru.liga.fat.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeriodUtilsTest {
    private LocalDate date;
    private LocalDate date2;

    public PeriodUtilsTest() {
        this.date = LocalDate.now().plusDays(2);
        this.date2 = LocalDate.now().minusDays(2);

    }

    @Test
    public void countDaysUntilDateWithoutExceptions() {
        PeriodUtils periodUtils = new PeriodUtils();
        assertNotNull(periodUtils.countDaysUntilDate(LocalDate.now().plusDays(2)));
        assertTrue(periodUtils.countDaysUntilDate(date).equals(2));
        assertTrue(periodUtils.countDaysUntilDate(date2).equals(-2));
    }
}