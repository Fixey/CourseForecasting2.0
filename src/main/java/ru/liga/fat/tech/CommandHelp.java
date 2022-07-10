package ru.liga.fat.tech;


import ru.liga.fat.tech.entity.RatesPrediction;

/**
 * Класс отвечающий за действия по команде Help
 */
public class CommandHelp implements Command {

    /**
     * Распечатывает список команд прогарммы
     *
     * @param commandParameters полная команда
     * @return List<List < ExchangeRates>> списки курсов
     */
    @Override
    public RatesPrediction invoke(CommandParameters commandParameters) {
        return new RatesPrediction();
    }
}