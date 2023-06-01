package javaProfessionalCourse2.lesson26.synchExample5.countDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class countDownEx {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        CountDownLatch cdl = new CountDownLatch(3);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread worker = new Thread(new Worker(i, cdl));
            worker.start();
        }

        try {
            cdl.await();
            System.out.println("Все потоки завершили свою работу");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    static class Worker implements Runnable {

        private final int idWorker;
        private final CountDownLatch cdl;

        public Worker(int idWorker, CountDownLatch cdl) {
            this.idWorker = idWorker;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("Thread: " + idWorker + " begin to work");
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(2000, 3000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Thread: " + idWorker + " finished to work");
            cdl.countDown();
        }
    }
}
