package ru.liga.fat.front;

public class OutputHelp {
    public String getHelpMessage() {
        String message = "Options:\n\n" +
                "Rate <eur, usd, try, bgn, amd> <today, tomorrow, week, month, dd/MM/yyyy>         Print forecasting rate\n\n"
                + "Help                                                                              Print commands for this app\n";
        return message;
    }
}
