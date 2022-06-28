package ru.liga.back;

import ru.liga.enums.Period;
import ru.liga.util.FileReader;

import java.util.LinkedList;

/**
 * Алгоритм курса по структуре нахождение среднего за n предыдущих дней
 */
public class AlgorithmForecastingOnAverageOfSomeDays implements RateAlgorithm {
    /**
     * Формирует лист Курса Валют на n дней
     *
     * @param currency Валюта
     * @param days     на сколько дней рассчитывать
     * @return LinkedList<ExchangeRates> лист Курса валют
     */
    @Override
    public LinkedList<ExchangeRates> getListResult(String currency, int days) {
        //Тащим файл
        FileReader fileReader = new FileReader();
        LinkedList<String> listLines = fileReader.getListLinesFromFile("/csv/" + currency + ".csv");
        //Формируем лист с файла Ставок курса
        LineParserToExchangeRate lineParser = new LineParserToExchangeRate();
        LinkedList<ExchangeRates> listExchangeRatesCSV = lineParser.getListExchangeRates(listLines, Period.Week.getNumDays());

        //Формируем Ставки для рассчета предсказанний
        CalculationForecastingRate calculationForecastingRate = new CalculationForecastingRate();
        LinkedList<ExchangeRates> resultExchangeRates = calculationForecastingRate.getListOfForecastingExchangeRates(listExchangeRatesCSV, days, currency);
        return resultExchangeRates;
    }
}
