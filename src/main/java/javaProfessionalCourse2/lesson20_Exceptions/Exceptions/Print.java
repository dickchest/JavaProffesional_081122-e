package javaProfessionalCourse2.lesson20_Exceptions.Exceptions;

import java.util.Arrays;
import java.util.List;

public class Print {
    void print(String s) {
        if (s == null) {
            throw new NullPointerException("Exception: S is null");
        }

        System.out.println("Inside metod print:" + s);
    }

    public static void main(String[] args) {
        Print print = new Print();
        List<String> list = Arrays.asList("first step", null,"second stap");
int count =0;
        for (String s : list) {
            try {
                count++;
                print.print(s);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("Exception was processed. Program continue");
            } finally {
                System.out.println("Step # " + count);
                System.out.println("Inside block finally");
            }
        System.out.println("Go programm...");
        System.out.println("--------------");
        }
    }
}
