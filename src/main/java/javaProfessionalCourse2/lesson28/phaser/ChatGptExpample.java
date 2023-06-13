package javaProfessionalCourse2.lesson28.phaser;

import java.util.concurrent.Phaser;

public class ChatGptExpample {
        static final int THREADS_COUNT = 3;
        static final int PHASES_COUNT = 4;
    public static void main(String[] args) {

        // инициализируем файзре
        Phaser phaser = new Phaser(THREADS_COUNT + 1); // считаем метод мейн

        // запускаем потоки
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread thread = new Thread(new Worker(phaser));
            thread.start();
        }

        // доходим до барьеров
        for (int phase = 0; phase < PHASES_COUNT; phase++) {
            System.out.println(Thread.currentThread().getName() + "=== Phase " + phase + " ===" + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
        }

        phaser.arriveAndDeregister();
        // ожидание завершения всех потоков
        System.out.println(phaser.getRegisteredParties());
        while (phaser.getRegisteredParties() > 0) {
            phaser.arriveAndAwaitAdvance();
        }
    }

    private static void sleepThread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Worker implements Runnable {
        private Phaser phaser;

        public Worker(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for (int i = 0; i < PHASES_COUNT; i++) {
                sleepThread(200);
                System.out.println(Thread.currentThread().getName() + " Phase " + i + " = " + phaser.getPhase());

                phaser.arriveAndAwaitAdvance();
            }

            // отмена регистрации потока
            phaser.arriveAndDeregister();
        }
    }
}
