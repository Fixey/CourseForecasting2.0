package ru.liga.front;

import ru.liga.back.AlgorithmSelector;
import ru.liga.back.ExchangeRates;
import ru.liga.back.RateAlgorithm;
import ru.liga.exception.CountDaysException;
import ru.liga.util.PeriodUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс отвечающий за действия по команде Rate
 */
public class CommandRate implements Command {
    /**
     * Запуск блока команд рассчитывающий курс на период
     *
     * @param listArgs список аргументов [Тип валюты, период]
     * @throws CountDaysException при не возможности подсчитать кол-во дней
     */
    public void invoke(LinkedList<String> listArgs) {

        new CommandRateValidation().ValidCommandRate(listArgs); //Проверим корректное написае команды

        String currency = listArgs.get(0).toUpperCase();
        String period = listArgs.get(1);
        Integer numDays = PeriodUtils.countDayForPeriod(period); //высчитываем кол-во дней за период
        if (numDays == null) {
            throw new CountDaysException();
        }
        String algorithmName = "";
        if (listArgs.size() == 3) {
            algorithmName = listArgs.get(2);
        }
        //Выбор алгоритма
        RateAlgorithm algorithm = new AlgorithmSelector().getAlgorithm(algorithmName);
        List<ExchangeRates> resultAlgorithm = algorithm.getListResult(currency, numDays); //Получение результата выполнение алгоритма

        //Формируем лист с предсказанными Курсами Валют
        resultAlgorithm.forEach(x -> System.out.println(x.getDateAndRate()));
    }
}
