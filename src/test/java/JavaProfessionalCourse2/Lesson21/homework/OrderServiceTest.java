package JavaProfessionalCourse2.Lesson21.homework;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @Test
    void placeOrder() {
        Database mockDatabase = Mockito.mock(Database.class);

        OrderService orderService = new OrderService(mockDatabase);

        OrderService.Order order = new OrderService.Order("1", "John", "keyboard", 10);

        // Заказываем товар и сохраняем заказ
        orderService.placeOrder(order);

        // Проверяем, что метод сохранения заказа в базе данных был вызван с правильными аргументами
        verify(mockDatabase).saveOrder(order);
    }
}