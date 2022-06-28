package ru.liga;

import ru.liga.front.ConsoleApp;

/**
 * Запуск программы
 */
public class Main {
    public static void main(String[] args) {
        ConsoleApp myApp = new ConsoleApp();
        myApp.consoleEngine(args);
        System.out.println("");
    }
}

