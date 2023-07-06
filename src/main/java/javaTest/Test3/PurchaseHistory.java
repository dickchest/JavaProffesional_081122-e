package javaTest.Test3;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/*
Создайте класс "История покупок клиента". В классе должно быть поле, тип которого Map. Ключи Map - даты заказа, значения - список заказанных наименований.
В основной программе создайте истории покупок для нескольких клиентов. С помощью Stream API нужно получить перечень всех наименований без повторений,
которые участвовали в заказах за прошедшие 30 дней от текущей даты. Перечень должен быть отсортирован по алфавиту. Выведите перечень в консоль.
 */
public class PurchaseHistory {
    Map<LocalDate, List<String>> purchaseMap;

    public PurchaseHistory() {
        purchaseMap = new HashMap<>();
    }

    public void addPurchase(LocalDate date, List<String> items) {
        purchaseMap.put(date, items);
    }

    public List<String> getUniqueItemsLast300Days(){
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusDays(30);

        return purchaseMap.entrySet().stream()
                .filter(entry -> entry.getKey().isAfter(startDate) || entry.getKey().isEqual(startDate))
                .flatMap(entry -> entry.getValue().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();

        // Добавляем истории покупок для нескольких клиентов
        purchaseHistory.addPurchase(LocalDate.now(), Arrays.asList("item1", "item2", "item3"));
        purchaseHistory.addPurchase(LocalDate.now().minusDays(5), Arrays.asList("item3", "item4", "item5"));
        purchaseHistory.addPurchase(LocalDate.now().minusDays(10), Arrays.asList("item2", "item3", "item6"));

        // Получаем перечень всех наименований без повторений, участвовавших в заказах за прошедшие 30 дней
        List<String> uniqueItems = purchaseHistory.getUniqueItemsLast300Days();

        // Выводим перечень в консоль
        System.out.println(uniqueItems);
    }
}
