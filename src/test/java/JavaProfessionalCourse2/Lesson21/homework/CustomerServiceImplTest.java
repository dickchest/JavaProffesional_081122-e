package JavaProfessionalCourse2.Lesson21.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    private CustomerService customerService;

    @BeforeEach
    void setUp(){

        Customer customer1 = new Customer(1, "John");
        Customer customer2 = new Customer(2, "Bill");
        Customer customer3 = new Customer(3, "Jane");

        customerService = new CustomerServiceImpl();

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);
        System.out.println(customerService);
    }

    @Test
    void getCustomerByIdTest() {
        Customer customerResult = customerService.getCustomerById(1);
        assertEquals("John", customerResult.getName());
    }

    @Test
    void getNoneCustomerByIdTest() {
        Customer customerResult = customerService.getCustomerById(4);
        assertNull(customerResult);
    }
}