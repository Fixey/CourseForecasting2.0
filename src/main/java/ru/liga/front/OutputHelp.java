//package ru.liga.front;
//
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import ru.liga.back.ExchangeRates;
//import ru.liga.telegram.Bot;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class OutputHelp implements IOutputRateCommander{
//    /**
//     * Отправка и обработка сообщения
//     *
//     * @param listExchangeRates список ставок который надо обработать
//     * @param chatId            Id чата для отправки сообщения
//     * @param bot
//     */
//    @Override
//    public void sendToOut(List<List<ExchangeRates>> listExchangeRates, String chatId, Bot bot) {
//        for (List<ExchangeRates> listExchangeRates : listExchangeRates)
//            listExchangeRates.forEach(System.out::println);
//        List<ExchangeRates> list = listExchangeRates.stream()
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//        String messageText = list.stream()
//                .sorted(Comparator.comparing(ExchangeRates::getDate).reversed())
//                .map(ExchangeRates::getDateAndRate).collect(Collectors.joining("\n"));
//        SendMessage sendMessage = SendMessage.builder()
//                .chatId(chatId)
//                .text(messageText)
//                .build();
//        try {
//            bot.execute(sendMessage);
//
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
