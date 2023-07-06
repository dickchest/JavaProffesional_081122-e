package homework.extraHomework5.traderApp.test;

import homework.extraHomework5.traderApp.entity.Transaction;
import homework.extraHomework5.traderApp.service.TransactionAnalysisService;

import java.util.ArrayList;
import java.util.List;

public class TransactionAnalysisServiceTest {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions = TransactionTestData.getTransactions();
        List<Transaction> testTransactions = TransactionAnalysisService.getTransactionBefore2011(transactions);
        System.out.println(testTransactions);
        List<Transaction> transactions2011 = TransactionAnalysisService.findTransactionsByYear(transactions, 2011);
        System.out.println(transactions2011);
        List<Transaction> transactions2012 = TransactionAnalysisService.findTransactionsByYear(transactions, 2012);
        System.out.println(transactions2012);

        System.out.println(TransactionAnalysisService.sortTransactions(transactions));

        System.out.println(TransactionAnalysisService.findTransactionByYearAndSort(transactions, 2011));

        System.out.println(TransactionAnalysisService.findAllTransactionsYears(transactions));
        System.out.println(TransactionAnalysisService.findAllUniqueTransactionsYears(transactions));
        System.out.println(TransactionAnalysisService.finaAllUniqueTraders(transactions));
        System.out.println(TransactionAnalysisService.finaAllUniqueTradersCities(transactions));
        System.out.println(TransactionAnalysisService.finaAllTradersFromCities(transactions, "cambridge"));
        System.out.println(TransactionAnalysisService.isTraderFromCity(transactions, "milan"));
        System.out.println(TransactionAnalysisService.maxTransaction(transactions));
        System.out.println(TransactionAnalysisService.minTransaction(transactions));
        System.out.println(TransactionAnalysisService.getAllTraders(transactions));
        System.out.println(TransactionAnalysisService.getAllCities(transactions));
    }
}
