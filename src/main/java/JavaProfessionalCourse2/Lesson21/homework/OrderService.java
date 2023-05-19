package JavaProfessionalCourse2.Lesson21.homework;
/*
    Создайте класс OrderService, который имеет метод placeOrder(), который
    создает новый заказ и сохраняет его в базе данных. Напишите тест, который
    проверяет, что метод placeOrder() правильно создает и сохраняет новый заказ.
 */
public class OrderService {
    Database database;
    public OrderService(Database database) {
        this.database = database;
    }

    void placeOrder(Order order) {
        database.saveOrder(order);
    }

    public static class Order {
        private String id;
        private String name;
        private String item;
        private int quantity;

        public Order(String id, String name, String item, int quantity) {
            this.id = id;
            this.name = name;
            this.item = item;
            this.quantity = quantity;
        }
    }
}
