package ru.liga.front;

import lombok.NonNull;
import ru.liga.exception.ConsoleException;

import java.util.Scanner;

public class ConsoleApp {
    /**
     * Командная оболчка
     *
     * @param command команда
     */
    public void consoleEngine(@NonNull String[] command) {
        while (true) {
            System.out.println("\nEnter your command:");
            Scanner scanner = new Scanner(System.in);
            String arg = scanner.nextLine();
            if (arg.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                ConsoleParser consoleParser = new ConsoleParser();
                Console console = consoleParser.consoleParser(arg);
                console.invokeCommand();
            } catch (Exception e) {
//                System.out.println(new ConsoleException(e));
                throw new ConsoleException(e);
            }
        }
    }

}
