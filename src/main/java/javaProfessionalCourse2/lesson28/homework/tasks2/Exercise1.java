package javaProfessionalCourse2.lesson28.homework.tasks2;

import java.util.Arrays;
import java.util.Random;

/*
1)	Написать программу для нахождения минимума и максимума в числовом
массиве/коллекции с помощью двух потоков.
Результаты вычислений возвращаются в метод main().
 */
public class Exercise1 {
    public static void main(String[] args) {
        int arrayLength = 100; // размер массива
        int[] array = new int[arrayLength]; // инициализация массива
        // заполнение массива рандомными значениями
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(-100,100);
        }
        System.out.println(Arrays.toString(array));

        // поток нахождени максимального числа
        Thread threadMax = new Thread(() -> {
            int max = array[0];
            for (int i = 1; i < arrayLength; i++) {
                max = Math.max(max, array[i]);
            }
            System.out.println("Max = " + max);
        });

        // поток нахождени минимальное числа
        Thread threadMin = new Thread(() -> {
            Arrays.stream(array)
                    .min()
                    .ifPresent(m -> System.out.println("Min =" + m));
        });

        threadMin.start();
        threadMax.start();

        try {
            threadMin.join();
            threadMax.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
