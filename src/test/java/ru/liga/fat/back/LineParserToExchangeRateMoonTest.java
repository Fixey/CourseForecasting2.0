//package ru.liga.forecasting.back;
//
//import org.junit.jupiter.api.Test;
//import ru.liga.forecasting.util.FileReader;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.LinkedList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LineParserToExchangeRateMoonTest {
//
//    @Test
//    void getListOfExchangeRatesWithoutExceptions() {
//        LineParserToExchangeRateMoon lineParserToExchangeRateMoon = new LineParserToExchangeRateMoon();
//        FileReader fileReader = new FileReader();
//        LinkedList<String> listLines = fileReader.getListLinesFromFile("/csv/USD.csv");
//        LinkedList<ExchangeRates> result = lineParserToExchangeRateMoon.getListExchangeRates(listLines,10, LocalDate.now().plusDays(1).minusYears(1));
//        assertEquals(result.size(),10);
//        assertEquals(result.get(0).getRate(), BigDecimal.valueOf(72.3723));
//
//    }
//}