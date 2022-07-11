package ru.liga.fat.csvfile;

import lombok.extern.slf4j.Slf4j;
import ru.liga.fat.csvfile.exception.FailFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class FileReader {
    /**
     * Читает файл и возвращает данные в виде Листа
     *
     * @param path путь к файлу
     * @return данные файла в виде листа
     * @throws FailFileException при падении с ошибкой при открытии файла
     */
    public List<String> getListLinesFromFile(String path) {
        try (InputStream in = getClass().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, "Cp1251"))) {
            List<String> listLines = new LinkedList<>();
            String line = reader.readLine();
            while (line != null) {
                listLines.add(line);
                line = reader.readLine();
            }
            return listLines;
        } catch (IOException | NullPointerException e) {
            log.error(e.getMessage(), e);
            throw new FailFileException();
        }
    }
}
