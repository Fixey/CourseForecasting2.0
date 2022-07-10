package ru.liga.fat.tech.util;

import org.junit.jupiter.api.Test;
import ru.liga.fat.tech.exception.FailFileException;
import ru.liga.fat.tech.util.FileReader;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    @Test
    void getFailFileException() {
        FileReader fileReader = new FileReader();
        assertThrows(FailFileException.class, () -> {
            fileReader.getListLinesFromFile("sdfs");
        });
    }
    @Test
    void getFile() {
        FileReader fileReader = new FileReader();
        assertThrows(FailFileException.class, () -> {
            fileReader.getListLinesFromFile("sdfs");
        });
    }
}