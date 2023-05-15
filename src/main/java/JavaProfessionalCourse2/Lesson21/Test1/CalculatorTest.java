package JavaProfessionalCourse2.Lesson21.Test1;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Test #1. Sum");
        int x = 5;
        int y = 10;

        int expectedResult = 50;
        int actualResult = calculator.sum(x,y);

        if (expectedResult == actualResult) {
            System.out.println("test #1 - OK!");
        } else {
            System.out.println("test #1 is FAIL!");
            System.out.println("Expected result: " + expectedResult +
                    ", but received: " + actualResult);
        }

        System.out.println("----------------------------");
        System.out.println("Test #2. Multiply");
        x = 5;
        y = 10;

        expectedResult = x * y;
        actualResult = calculator.multiply(x,y);

        if (expectedResult == actualResult) {
            System.out.println("test #2 - OK!");
        } else {
            System.out.println("test #2 is FAIL!");
            System.out.println("Expected result: " + expectedResult +
                    ", but received: " + actualResult);
        }


    }
}
