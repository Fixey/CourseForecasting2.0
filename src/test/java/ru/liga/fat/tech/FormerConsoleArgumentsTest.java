package ru.liga.fat.tech;

import org.junit.jupiter.api.Test;
import ru.liga.fat.command.FormerConsoleArguments;
import ru.liga.fat.command.exception.ArgumentsOptionFormatterException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FormerConsoleArgumentsTest {

    @Test
    void getArgumentsOptionFormatterException() {
        FormerConsoleArguments formerConsoleArguments = new FormerConsoleArguments();
        assertThrows(ArgumentsOptionFormatterException.class, () -> {
            formerConsoleArguments.getCommandLineFromCommand("Hello");
        });
    }
}