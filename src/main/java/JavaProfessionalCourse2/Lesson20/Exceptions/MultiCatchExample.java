package JavaProfessionalCourse2.Lesson20.Exceptions;

import java.util.Scanner;

public class MultiCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(n + "is a " + (99%n==0) + " factor of 99");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException" + e.getMessage());
        } catch (Exception e)  {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
