package javaProfessionalCourse2.lesson24_threads_priority_interrupt;

import java.util.concurrent.TimeUnit;

public class App2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Thread(() -> {
            try {
                System.out.println("Theread " + Thread.currentThread().getName() + " started!");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Theread " + Thread.currentThread().getName() + " finished!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread = new Thread(task);

        thread.start();
        thread.join();

        System.out.println("Main method finished");
    }
}
