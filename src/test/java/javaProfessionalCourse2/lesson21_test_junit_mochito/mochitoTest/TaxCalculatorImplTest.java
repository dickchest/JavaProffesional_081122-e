package javaProfessionalCourse2.lesson21_test_junit_mochito.mochitoTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaxCalculatorImplTest {


    @Test
    void testCalculatorTax2011() {
        CurrentYearProvider currentYearProvider = mock(CurrentYearProvider.class);
        TaxCalculatorImpl calculator = new TaxCalculatorImpl(currentYearProvider);

        when (currentYearProvider.getYear()).thenReturn(2011);

        double tax = calculator.calculatorTax(100);
        assertEquals(22, tax);
    }
}