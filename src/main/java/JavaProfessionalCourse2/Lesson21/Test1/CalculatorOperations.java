package JavaProfessionalCourse2.Lesson21.Test1;

public class CalculatorOperations {
    int typeOfOperations;
    Calculator calculator;


    public void operation(int x, int y) {
        if (typeOfOperations ==1) {calculator.sum(x, y);}
        if (typeOfOperations ==2) {calculator.multiply(x, y);}
    }
}
