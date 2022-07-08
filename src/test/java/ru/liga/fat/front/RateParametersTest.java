package ru.liga.fat.front;

import org.junit.jupiter.api.Test;

import java.util.Map;

class RateParametersTest {

    @Test
    void getParameters() {
        RateParameters rateParameters = new RateParameters("rate usd,eur -period week -alg mist -output list");
        Map<String, Object> params = rateParameters.getMepOfParameters();
        System.out.println(params);
    }
}