package JavaProfessionalCourse2.Lesson22.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PayRollTest {
    private PayRoll payRoll;
    private EmployeeDB employeeDB;

    private BankService bankService;

    private List<Employee> employees;

    @Before
    public void init() {
        //System.out.println("before");
        employees = new ArrayList<>();
        employeeDB = Mockito.mock(EmployeeDB.class);
        bankService = mock(BankService.class);

        when(employeeDB.getAllEmployees()).thenReturn(employees);

        payRoll = new PayRoll(employeeDB, bankService);
    }

    @Test
    public void testNoEmployee() {
        assertNumberOfPayments(0);
    }

    @Test
    public void testSingleEmployee() {
        employees.add(new Employee("Test Employy", "123", 1000));
        assertNumberOfPayments(1);
    }


    @Test
    public void testOnlyOneInteractionWithDB() {
        payRoll.monthlyPayment();
        // метод должен протестировать геталл емплои и мы хотим убедиться, что он выполняется только один раз
        verify(employeeDB, times(1)).getAllEmployees();
    }

    @Test
    public void testEmployeeIsPaid() {
        String employeeId = "123";
        int salary = 1000;
        employees.add(new Employee("Test Employy", employeeId, salary));
        assertNumberOfPayments(1);
        verify(bankService, times(1)).makePayment(employeeId, salary);
    }

    @Test
    public void testAllEmployeesArePaid() {
        employees.add(new Employee("Test Employee1", "ID1", 1000));
        employees.add(new Employee("Test Employee2", "ID2", 1000));

        assertNumberOfPayments(2);

        ArgumentCaptor<String> idCaptor = ArgumentCaptor.forClass(String.class); // захватчик
        ArgumentCaptor<Integer> salaryCaptor = ArgumentCaptor.forClass(Integer.class); // захватчик

        verify(bankService, times(2)).makePayment(idCaptor.capture(), salaryCaptor.capture());

        assertEquals("ID1", idCaptor.getAllValues().get(0));
        assertEquals("ID2", idCaptor.getAllValues().get(1));
        assertEquals(1000, salaryCaptor.getAllValues().get(0).intValue());
        assertEquals(1000, salaryCaptor.getAllValues().get(1).intValue());
    }

    @Test
    public void testInteractionOrder() {
        String employeeID = "ID1";
        int salary = 1000;

        employees.add(new Employee("TestEmployee", employeeID, salary));

        assertNumberOfPayments(1);

        InOrder inOrder = inOrder(employeeDB, bankService);
        inOrder.verify(employeeDB).getAllEmployees();
        inOrder.verify(bankService).makePayment(employeeID, salary);
    }


    private void assertNumberOfPayments(int expected) {
        int numberOfPayments = payRoll.monthlyPayment();
        assertEquals(expected, numberOfPayments);
    }
}