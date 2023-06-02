package javaProfessionalCourse2.lesson27.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class DeliveryExample {
    public static void main(String[] args) {

        // создаем Exchanger
        Exchanger<List<String>> exchanger = new Exchanger<>();

        // созддаем список товаров
        List<String> goods1 = List.of("Item1", "Item2", "Item3");
        List<String> goods2 = List.of("Item4", "Item5", "Item6");

        Truck truck1 = new Truck(1, "Factory A", "Warehouse C", goods1, exchanger);
        Truck truck2 = new Truck(2, "Factory B", "Warehouse D", goods2, exchanger);

        new Thread(truck1).start();
        new Thread(truck2).start();

    }
}
