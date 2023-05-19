package Algorithms.lesson1;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 1е число: ");
        int num1 = scanner.nextInt();

        System.out.println("Введите 2е число: ");
        int num2 = scanner.nextInt();

        System.out.println("Введите 3е число: ");
        int num3 = scanner.nextInt();

        sum = num1 + num2 + num3;

        System.out.println(sum);
    }
}
