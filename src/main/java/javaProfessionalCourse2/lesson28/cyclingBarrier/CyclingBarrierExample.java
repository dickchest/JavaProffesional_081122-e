package javaProfessionalCourse2.lesson28.cyclingBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
колесо обозрения
в кабину может сесть только четыре человека
 */
public class CyclingBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4, () -> {
            System.out.println("4 treads come to barrier");
        });
        for (int i = 0; i < 12; i++) {
            Thread thread = new Thread(new Guests(i, cb));
            thread.start();
        }

    }

    static class Guests implements Runnable {
        private final int id;
        private final CyclicBarrier cb;

        public Guests(int id, CyclicBarrier cb) {
            this.id = id;
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000,4000));
                System.out.println("Guest " + id + " stay in line");
                System.out.println(cb.getNumberWaiting() + " ожидает");
                cb.await();
                System.out.println("Guest " + id + " enter a cabin");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
