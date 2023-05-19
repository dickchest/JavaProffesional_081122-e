package JavaProfessionalCourse2.Lesson20.Exceptions;

public class FirstExceptionExample {
    public static void main(String[] args) {


        System.out.println(divide(4, 2));
        System.out.println(divide(2, 0));

        System.out.println("finish");
    }

    public static double divide(int x, int y) {
        double result = x / y;
        return result;
    }
}
