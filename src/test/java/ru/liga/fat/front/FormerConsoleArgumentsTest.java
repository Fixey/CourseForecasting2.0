package ru.liga.fat.front;

import org.junit.jupiter.api.Test;
import ru.liga.fat.exception.ArgumentsOptionFormatterException;

import static org.junit.jupiter.api.Assertions.*;

class FormerConsoleArgumentsTest {

    @Test
    void getArgumentsOptionFormatterException() {
        FormerConsoleArguments formerConsoleArguments = new FormerConsoleArguments();
        assertThrows(ArgumentsOptionFormatterException.class, () -> {
            formerConsoleArguments.getCommandLineFromCommand("Hello");
        });
    }
}