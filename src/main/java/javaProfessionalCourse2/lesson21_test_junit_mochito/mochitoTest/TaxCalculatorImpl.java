package javaProfessionalCourse2.lesson21_test_junit_mochito.mochitoTest;

public class TaxCalculatorImpl {

    private CurrentYearProvider currentYearProvider;

    public TaxCalculatorImpl(CurrentYearProvider currentYearProvider) {
        this.currentYearProvider = currentYearProvider;
    }

    public double calculatorTax(double income) {
        double taxAmount;

        if (currentYearProvider.getYear() == 2011) {
            taxAmount = income * 0.22;
        } else {
            taxAmount = income * 18;
        }
        return taxAmount;
    }
}