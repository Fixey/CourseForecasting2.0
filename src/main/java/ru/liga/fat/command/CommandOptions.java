package ru.liga.fat.command;

import org.apache.commons.cli.Options;

/**
 * Декларация флагов в команде
 */
public class CommandOptions {
    public Options getCommandOptions() {
        Options options = new Options();
        options.addOption("date", "date", true, "Data for forecasting rate");
        options.addOption("period", "period", true, "Period for forecasting rate");
        options.addRequiredOption("alg", "alg", true, "Algorithm for forecasting rate");
        options.addOption("output", "output", true, "Output is have to be returned ");
        return options;
    }

}
