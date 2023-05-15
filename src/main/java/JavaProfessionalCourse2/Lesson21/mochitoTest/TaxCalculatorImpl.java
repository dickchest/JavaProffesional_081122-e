package JavaProfessionalCourse2.Lesson21.mochitoTest;

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