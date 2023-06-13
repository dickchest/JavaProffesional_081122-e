package javaProfessionalCourse2.lesson28.homework.tasks2;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
2)	Условие задачи. Заданы три целочисленных массива.
Записать эти массивы в файл в параллельных потоках.
Создать класс SaveAsThread для представления потока,
который записывает целочисленный массив в файл.
записать всю информацию в один файл.
 */
public class Exercise2version2 {

    public static void main(String[] args) {

        // Заданы три целочисленных массива
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] array3 = {11, 12, 13, 14, 15};

        // Инициализация переменных
        String filePath = "File123.txt";

        // run Threads
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(filePath))) {

            ExecutorService executor = Executors.newFixedThreadPool(3);
            Lock lock = new ReentrantLock();

            executor.execute(new FileWriter(array1, bw, lock));
            executor.execute(new FileWriter(array2, bw, lock));
            executor.execute(new FileWriter(array3, bw, lock));

            executor.shutdown();

            while (!executor.isTerminated()) {
                // ожидание завершения всех потоков
            }

            System.out.println("Arrays have been saved to files");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class FileWriter implements Runnable {
        private final int[] array;
        private final BufferedWriter bufferedWriter;

        private final Lock lock;

        public FileWriter(int[] array, BufferedWriter bufferedWriter, Lock lock) {
            this.array = array;
            this.bufferedWriter = bufferedWriter;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock(); // захватываем блокировку
                for (int element : array) {
                    bufferedWriter.write(Integer.toString(element));
                    bufferedWriter.newLine();
//                    System.out.println("Thread " + Thread.currentThread().getName() + " writing " + element);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock(); // освобождаем блокировку в любом случае
            }
        }
    }
}
