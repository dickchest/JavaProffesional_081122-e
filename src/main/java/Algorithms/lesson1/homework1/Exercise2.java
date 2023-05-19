package Algorithms.lesson1.homework1;
/*
Level 2
Реализовать алгоритм, который будет находить сумму квадратов всех элементов массива! {3, 6, 4,
7, 2, 1, 9}
Задание считается выполненным если: использован ”Линейный подход” и алгоритм соответствует
характеристикам алгоритма и выдает верный результат
 */
public class Exercise2 {
    public static void main(String[] args) {
        int[] array = {3, 6, 4, 7, 2, 1, 9};
        System.out.println(sumSqrt(array));
    }

    public static int sumSqrt(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i] * array[i];
            sum += temp;
        }
        return sum;
    }
}
