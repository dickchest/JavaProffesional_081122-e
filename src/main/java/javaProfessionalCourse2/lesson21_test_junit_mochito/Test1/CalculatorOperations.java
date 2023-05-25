package javaProfessionalCourse2.lesson21_test_junit_mochito.Test1;

public class CalculatorOperations {
    int typeOfOperations;
    Calculator calculator;


    public void operation(int x, int y) {
        if (typeOfOperations ==1) {calculator.sum(x, y);}
        if (typeOfOperations ==2) {calculator.multiply(x, y);}
    }
}
