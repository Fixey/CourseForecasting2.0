package ru.liga.fat.sending;

import lombok.Getter;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Объект для хранения информации
 */
@Getter
public class SendingMessage {
    /**
     * Хранимые файлы
     */
    private List<File> listFile = new LinkedList<>();
    /**
     * Хранимые текстовые сообщения
     */
    private List<String> listMessage = new LinkedList<>();

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
