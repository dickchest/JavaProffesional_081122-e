package javaProfessionalCourse2.lesson25.interrupt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class InterruptedExample3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
//                    break; // либо так, либо следующая строчка, что бы прервать внешний цикл
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread tr = new Thread(task);

        tr.start();
        Thread.sleep(1000);

        tr.interrupt();


    }
}
