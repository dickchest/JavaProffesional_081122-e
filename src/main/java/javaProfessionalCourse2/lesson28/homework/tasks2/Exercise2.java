package javaProfessionalCourse2.lesson28.homework.tasks2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/*
2)	Условие задачи. Заданы три целочисленных массива.
Записать эти массивы в файл в параллельных потоках.
Создать класс SaveAsThread для представления потока,
который записывает целочисленный массив в файл.
Задачу решить двумя способами: записать каждый массив в отдельный
файл (на выходе вы должны получить три файла) и записать всю
информацию в один файл.

И обратная задача. Чтение из файла массивов чисел.
Заданы три файла с именами «File1.txt», «File2.txt», «File3.txt».
В каждом из файлов записаны целочисленные массивы.
Прочитать эти значения и сохранить в коллекции.
 */
public class Exercise2 {
        static Random random = new Random();
    public static void main(String[] args) {
        // Заданы три целочисленных массива
        int arraysLength = 10;
        int[] arrayA = new int[arraysLength]; // инициализируем 3 массива
        int[] arrayB = new int[arraysLength]; // инициализируем 3 массива
        int[] arrayC = new int[arraysLength]; // инициализируем 3 массива
        for (int i = 0; i < arraysLength; i++) {
            arrayA[i] = random.nextInt(-100, 100);
            arrayB[i] = random.nextInt(-100, 100);
            arrayC[i] = random.nextInt(-100, 100);
        }

        // Инициализация переменных
        String filePathA = "File1.txt";
        String filePathB = "File2.txt";
        String filePathC = "File3.txt";

        // run Threads
        Thread threadA = new Thread(new SaveAsThread(filePathA, arrayA));
        Thread threadB = new Thread(new SaveAsThread(filePathB, arrayB));
        Thread threadC = new Thread(new SaveAsThread(filePathC, arrayC));
        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Чтение из файлов
        AtomicReference<List<Integer>> listA = new AtomicReference<>(new ArrayList<>());
        AtomicReference<List<Integer>> listB = new AtomicReference<>(new ArrayList<>());
        AtomicReference<List<Integer>> listC = new AtomicReference<>(new ArrayList<>());

        // создание потоков
        Thread readerA = new Thread(() -> {
            listA.set(readFromFile(filePathA));
        });

        Thread readerB = new Thread(() -> {
            listB.set(readFromFile(filePathB));
        });

        Thread readerC = new Thread(() -> {
            listC.set(readFromFile(filePathC));
        });


        // запуск потоков

        readerA.start();
        readerB.start();
        readerC.start();

        // ждем окончание всех потоков
        try {
            readerA.join();
            readerB.join();
            readerC.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // вывод результата на экран
        System.out.println(listA);
        System.out.println(listB);
        System.out.println(listC);

    }

    private static List<Integer> readFromFile(String path) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
//                System.out.println("Thread: " + Thread.currentThread().getName() + " write " + line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    static class SaveAsThread implements Runnable {
        String path;
        int[] array;

        public SaveAsThread(String path, int[] array) {
            this.path = path;
            this.array = array;
        }

        @Override
        public void run() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (int i : array) {
                    bw.write(Integer.toString(i));
                    bw.newLine();
                }
                System.out.println("File " + path + " successfully recorded");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
