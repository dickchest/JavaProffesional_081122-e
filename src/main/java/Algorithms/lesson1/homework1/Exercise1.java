package Algorithms.lesson1.homework1;

import java.util.Arrays;

/*
Level 1
Найти индекс заданного числа в массиве: {3, 6, 4, 7, 2, 1, 9}
Алгоритм на вход должен получать любой массив и одну цифру, индекс которой требуется найти.
Задание считается выполненным если: использован ”Линейный подход” начиная от последнего
элемента и алгоритм соответствует характеристикам алгоритма и выдает верный результат. Используйте
блок схему
 */
public class Exercise1 {
    public static void main(String[] args) {
        int[] array = {3, 6, 4, 7, 2, 1, 9};
        int toFind = 8;
        Integer result = null;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == toFind) {
                result = i;
            }
        }
        if (result != null) {
            System.out.println("Элемент найден на " + result + " позиции.");
        } else {
            System.out.println("Такой элемент не найден");
        }
    }
    
    

}
