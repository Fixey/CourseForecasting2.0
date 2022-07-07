package ru.liga.fat.front;

import lombok.Data;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Объект для хранения информации
 */
@Data
public class SendingMessage {
    /**
     * Хранимые файлы
     */
    public List<File> listFile = new LinkedList<>();
    /**
     * Хранимые текстовые сообщения
     */
    public List<String> listMessage = new LinkedList<>();

    /**
     * Доабвить файл
     *
     * @param file файл
     */
    public void addFile(File file) {
        listFile.add(file);
    }

    /**
     * Добавить сообщение
     *
     * @param message message
     */
    public void addMessage(String message) {
        listMessage.add(message);
    }
}
