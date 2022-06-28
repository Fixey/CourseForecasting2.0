package ru.liga.enums;

import java.time.LocalDate;

import static ru.liga.util.PeriodUtils.countDaysUntilDate;

public enum Period {
    Today(0),
    Tomorrow(1),
    Week(7),
    Month(countDaysUntilDate(LocalDate.now().plusMonths(1))),
    Year(countDaysUntilDate(LocalDate.now().plusYears(1))
    );

    private final int numDays;


    Period(int numDays) {
        this.numDays = numDays;
    }

    public int getNumDays() {
        return numDays;
    }
}
