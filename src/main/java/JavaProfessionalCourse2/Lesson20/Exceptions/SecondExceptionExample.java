package JavaProfessionalCourse2.Lesson20.Exceptions;

public class SecondExceptionExample {
    public static void main(String[] args) {


        try {
            System.out.println(divide(4, 2));
            System.out.println(divide(2, 0));
        } catch (ArithmeticException exception) {
            System.out.println("Error devided by zero");
            exception.printStackTrace();
        }
        System.out.println("finish");
    }

    public static double divide(int x, int y) {
        double result = x / y;
        return result;
    }
}
