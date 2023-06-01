package javaProfessionalCourse2.lesson27.cyclingBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclingBarrierExample {
    private static final int NUMBER_THREADS = 15;

    public static void main(String[] args) {
        // созданим сайлинг барьер

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("Четыре потока достигли нашего барьера и выполняется действие после этого момента");
        }); // сколько у барьера должно собраться потоков

        // создаем и запускаем потоки
        for (int i = 0; i < NUMBER_THREADS; i++) {
            Thread thread = new Thread(new Worker(i, cyclicBarrier));
            thread.start();
        }
    }

    static class Worker implements Runnable {

        private final int idWorker;

        private final CyclicBarrier cyclicBarrier;

        public Worker(int idWorker, CyclicBarrier cyclicBarrier) {
            this.idWorker = idWorker;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Thread "+ idWorker + " begin to work");
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(2000, 3000));
                System.out.println("Thread "+ idWorker + " подошел к барьеру");
                cyclicBarrier.await();
                System.out.println("Thread "+ idWorker + " продолжает работу после барьера");
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
