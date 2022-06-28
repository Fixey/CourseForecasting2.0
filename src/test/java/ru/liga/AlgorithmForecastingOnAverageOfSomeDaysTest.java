package ru.liga;


import org.junit.jupiter.api.Test;
import ru.liga.back.AlgorithmForecastingOnAverageOfSomeDays;

public class AlgorithmForecastingOnAverageOfSomeDaysTest {
    @Test
    public void getForecastingRateWithoutExceptions() {
        AlgorithmForecastingOnAverageOfSomeDays forecastingRate = new AlgorithmForecastingOnAverageOfSomeDays();
        forecastingRate.getListResult("USD", 2);


    }
}
