//package ru.liga.fat.front;
//
//import org.junit.jupiter.api.Test;
//import ru.liga.fat.exception.ConsoleArgsException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class ConsoleParserTest {
//
////    @Test
////    void consoleParser() {
////        ConsoleParser consoleParser = new ConsoleParser();
////        Console console = consoleParser.consoleParser("rate usd -period week -alg mist -output list");
////        assertEquals(console, new Console("rate", "rate usd -period week -alg mist -output list"));
////    }
//
//    @Test
//    void getConsoleArgsException() {
//        ConsoleParser consoleParser = new ConsoleParser();
//        assertThrows(ConsoleArgsException.class, () -> {
//            consoleParser.consoleParser(null);
//        });
//    }
//}