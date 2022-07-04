package ru.liga.front;

import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.Test;
import ru.liga.exception.ArgumentsOptionFormatterException;

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