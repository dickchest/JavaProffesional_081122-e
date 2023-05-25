package javaProfessionalCourse2.lesson21_test_junit_mochito.Test2;

public class TaxCalculatorImpl implements TaxCalculator {
    @Override
    public double calculatorTax(double income) {
        double taxAmount;
        if (income <= 20_000) {
            taxAmount = income * 0.25;
        } else {
            taxAmount = 20000 * 0.25 + (income - 20_000) * 0.40;
        }
        return taxAmount;
    }
}