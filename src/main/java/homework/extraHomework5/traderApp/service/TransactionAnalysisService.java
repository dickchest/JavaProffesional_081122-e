package homework.extraHomework5.traderApp.service;

import homework.extraHomework5.traderApp.entity.Trader;
import homework.extraHomework5.traderApp.entity.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Напишите метод, который принимает на вход список транзакций
и находит все транзакции совершённые в 2011 году. Реализацию
этого метода напишите с использованием Stream API.
 */
public class TransactionAnalysisService {
    public static List<Transaction> getTransactionBefore2011(List<Transaction> transactions) {
        List<Transaction> result = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .collect(Collectors.toList());
        return result;
    }

    public static List<Transaction> findTransactionsByYear(List<Transaction> transactions, int year) {
        List<Transaction> result = transactions.stream()
                .filter(x -> x.getYear() == year)
                .collect(Collectors.toList());
        return result;
    }

    public static List<Transaction> sortTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public static List<Transaction> findTransactionByYearAndSort(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(x-> x.getYear() == year)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(Collectors.toList());
    }

    public static List<Integer> findAllTransactionsYears(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.mapping(x -> x.getYear(), Collectors.toList()));
    }

    public static List<Integer> findAllUniqueTransactionsYears(List<Transaction> transactions) {
        return transactions.stream()
                .map(x -> x.getYear())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Trader> finaAllUniqueTraders(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> finaAllUniqueTradersCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }
    public static List<String> finaAllTradersFromCities(List<Transaction> transactions, String city) {
        return transactions.stream()
                .filter(x -> x.getTrader().getCity().equalsIgnoreCase(city))
                .map(x -> x.getTrader().getName())
                .distinct()
                .collect(Collectors.toList());
    }

    public static boolean isTraderFromCity(List<Transaction> transactions, String city) {
        return transactions.stream()
                .anyMatch(x-> city.equalsIgnoreCase(x.getTrader().getCity()));
    }

    public static int maxTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare)
                .get();
    }

    public static int minTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getValue)
                .get();
    }

    public static String getAllTraders(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));
    }

    public static String getAllCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));
    }
}
