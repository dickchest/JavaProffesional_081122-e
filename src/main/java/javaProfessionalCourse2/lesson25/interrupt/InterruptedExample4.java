package javaProfessionalCourse2.lesson25.interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptedExample4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());

            while (!Thread.currentThread().isInterrupted()) {
                // Do some work
            }
            System.out.println("Finished");
        };

        Thread tr = new Thread(task);

        tr.start();
        Thread.sleep(1000); // main to sleep 1 sec
        tr.interrupt();
    }
}
