//package ru.liga.front;
//
//import ru.liga.exception.ConsoleException;
//
//import java.util.Scanner;
//
//public class ConsoleApp {
//    /**
//     * Командная оболочка
//     */
//    public void consoleEngine() {
//        while (true) {
//            System.out.println("\nEnter your command:");
//            Scanner scanner = new Scanner(System.in);
//            final String arg = scanner.nextLine();
//            try {
//                ConsoleParser consoleParser = new ConsoleParser();
//                Console console = consoleParser.consoleParser(arg);
//                console.invokeCommand();
//            } catch (Exception e) {
//                throw new ConsoleException(e);
//            }
//        }
//    }
//
//}
