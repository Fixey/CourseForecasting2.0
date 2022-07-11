package ru.liga.fat.command.exception;


public class PeriodRequiredInRateCommandException extends RuntimeException {
    public PeriodRequiredInRateCommandException() {
        super("Output is required parameter if there is period!");
    }
}
