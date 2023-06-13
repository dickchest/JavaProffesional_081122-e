package javaProfessionalCourse2.lesson28.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Worker("Name " + i, semaphore));
            thread.start();
        }

    }


    static class Worker implements Runnable {
        Semaphore semaphore;
        String name;

        public Worker(String name, Semaphore semaphore) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " waiting for permission");
                semaphore.acquire();
                System.out.println(name + " permission granted");
                Thread.sleep(2000);
                System.out.println(name + " releases permission");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
