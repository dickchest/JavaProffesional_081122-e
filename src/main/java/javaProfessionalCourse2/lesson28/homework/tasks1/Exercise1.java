package javaProfessionalCourse2.lesson28.homework.tasks1;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*
1. Дан массив n-элементов. Вычислить колличество заданного символа K.
Выполнить обработку массива двумя способами: без потоков и с потоками.
 */
public class Exercise1 {
    public static void main(String[] args) {
        int n = 1000;
        int[] arr = new int[n];
        int k = 35;
        int count = 0; // переменная для сохранения количества элементов K

        // задаем массив случайным образом
        inputArray(arr);

        // Вычисляем кол-во заданного символа K. Без потоков
        long currentTime = System.currentTimeMillis();
        count = getCountNoThreads(arr, k);
        System.out.println("Кол-во элементов \"" + k + "\" в массиве = " + count);
        System.out.println("Время = " + (System.currentTimeMillis() - currentTime));

        currentTime = System.currentTimeMillis();
        count = getCountWithThreads(arr, k);
        System.out.println("Кол-во элементов \"" + k + "\" в массиве = " + count);
        System.out.println("Время = " + (System.currentTimeMillis() - currentTime));
    }

    private static int getCountWithThreads(int[] arr, int k) {
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger currentIndex = new AtomicInteger(0);

        Runnable tread = () -> {
            if (currentIndex.get() == arr.length) return;
            while (currentIndex.get() < arr.length) {
                if (arr[currentIndex.get()] == k) {
                    count.getAndIncrement();
                }
                currentIndex.getAndIncrement();
//                System.out.println(Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(tread, "Thread" + i);
            t.start();
        }
        return count.get();
    }

    private static int getCountNoThreads(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                count++;
            }
        }
        return count;
    }

    private static void inputArray(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
    }
}
