package ru.liga.fat.front;

/**
 * Вывод команды Help
 */
public class OutputHelp {
    public String getHelpMessage() {
        return "Options:\n\n" +
                "Rate <eur, usd, try, bgn, amd> <today, tomorrow, week, month, dd/MM/yyyy>         Print forecasting rate\n\n"
                + "Help                                                                              Print commands for this app\n";
    }
}
