package javaProfessionalCourse2.lesson21_test_junit_mochito.Test2;

import static org.junit.Assert.assertEquals;

class TaxCalculatorImplTest {

    @org.junit.jupiter.api.Test
    void calculatorTax1() {
        TaxCalculator calculator = new TaxCalculatorImpl();
        double income = 100;
        double expectedTax = 25;
        double actualTax = calculator.calculatorTax(income);

        assertEquals(expectedTax, actualTax, 0.0005);
    }

    @org.junit.jupiter.api.Test
    void calculatorTax2() {
        TaxCalculator calculator = new TaxCalculatorImpl();
        double income = 21000;
        double expectedTax = 5400;
        double actualTax = calculator.calculatorTax(income);

        assertEquals(expectedTax, actualTax, 0.0005);
    }
}