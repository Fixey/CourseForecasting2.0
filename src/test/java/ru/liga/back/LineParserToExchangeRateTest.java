package ru.liga.back;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class LineParserToExchangeRateTest {

    @Test
    void getListExchangeRates() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("nominal;data;curs;cdx");
        linkedList.add("1;01.02.2022;” 86,5032”;Евро");
        linkedList.add("1;01.02.2022;” 86,5032”;Евро");
        LineParserToExchangeRate lineParserToExchangeRate = new LineParserToExchangeRate();
        lineParserToExchangeRate.getListExchangeRates(linkedList, 2);
    }
}