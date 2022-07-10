package ru.liga.fat.tech.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PeriodUtilsTest {
    final private LocalDate date;
    final private LocalDate date2;

    public PeriodUtilsTest() {
        this.date = LocalDate.now().plusDays(2);
        this.date2 = LocalDate.now().minusDays(2);

    }

    @Test
    public void countDaysUntilDateWithoutExceptions() {
        PeriodUtils periodUtils = new PeriodUtils();
        assertNotNull(PeriodUtils.countDaysUntilDate(LocalDate.now().plusDays(2)));
        assertEquals(2, (int) PeriodUtils.countDaysUntilDate(date));
        assertEquals(-2, (int) PeriodUtils.countDaysUntilDate(date2));
    }
}