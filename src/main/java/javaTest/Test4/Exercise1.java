package javaTest.Test4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
Создайте консольное приложение, в котором выведите в консоль вычисление следующих примеров: 10L/4, 10L/2, 10L/0.
Если в программе возникает исключение, то сообщение об исключении нужно вывести в файл err.log.
 */
public class Exercise1 {
    public static void main(String[] args) {
        try {

        long result1 = 10L/4;
        System.out.println(result1);

        long result2 = 10L/2;
        System.out.println(result2);

        long result3 = 10L/0;
        System.out.println(result3);

        } catch (ArithmeticException e) {
            String errorMessage = "Произошло исключение: " + e.getMessage();
            System.err.println(errorMessage);

            try {
                PrintWriter writer = new PrintWriter(new File("err.log"));
                writer.println(errorMessage);
                writer.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка при записив файл: " + ex.getMessage());
            }
        }
    }
}
