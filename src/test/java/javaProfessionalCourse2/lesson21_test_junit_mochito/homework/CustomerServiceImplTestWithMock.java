package javaProfessionalCourse2.lesson21_test_junit_mochito.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerServiceImplTestWithMock {
    private CustomerService customerService;

    @BeforeEach
    void setUp(){

        Customer customer1 = new Customer(1, "John");
        Customer customer2 = new Customer(2, "Bill");
        Customer customer3 = new Customer(3, "Jane");

        customerService = mock(CustomerService.class);

        List<Customer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);

        when(customerService.getCustomerById(1)).thenReturn(customer1);
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