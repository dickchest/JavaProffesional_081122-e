package javaProfessionalCourse2.lesson27.executors;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadExecutrosExample {
    public static void main(String[] args) {
        // создадим сервис с помощью екекьютор
        // который будет решать задачи в пуле из 5 потоков

        ExecutorService executorService = Executors.newFixedThreadPool(5); // сервиз где 5 поток мы хотим обедининть

        Runnable task1 = () -> {
            System.out.println("Задача № 1 запущена и выполняется");
        };

        Runnable task2 = () -> {
            System.out.println("Задача № 2 запущена и выполняется");
        };

        Runnable task3 = () -> {
            System.out.println("Задача № 3 запущена и выполняется");
        };

        for (int i = 0; i < 10; i++) {
            System.out.println("Блок задач № " + i);
            executorService.execute(task1);
            executorService.execute(task2);
            executorService.execute(task3);
        }

        executorService.shutdown();

    }
}
