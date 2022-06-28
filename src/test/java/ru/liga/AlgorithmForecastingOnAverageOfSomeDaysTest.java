package ru.liga;


import org.junit.jupiter.api.Test;
import ru.liga.back.AlgorithmForecastingOnAverageOfSomeDays;
import ru.liga.enums.CurrencyType;

public class AlgorithmForecastingOnAverageOfSomeDaysTest {
    @Test
    public void getForecastingRateWithoutExceptions() {
        AlgorithmForecastingOnAverageOfSomeDays forecastingRate = new AlgorithmForecastingOnAverageOfSomeDays();
        forecastingRate.getListResult(CurrencyType.valueOf("USD"), 2);


    }
}
