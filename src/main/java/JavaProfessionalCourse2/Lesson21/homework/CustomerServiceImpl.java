package JavaProfessionalCourse2.Lesson21.homework;

import java.util.HashMap;
import java.util.Map;

/*
   Создайте класс CustomerService, который имеет метод getCustomerById(),
    который возвращает объект Customer по его идентификатору. Напишите тест,
    который проверяет, что метод getCustomerById() возвращает правильный
    объект Customer для заданного идентификатора.
 */
public class CustomerServiceImpl implements CustomerService{
    Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }
}
