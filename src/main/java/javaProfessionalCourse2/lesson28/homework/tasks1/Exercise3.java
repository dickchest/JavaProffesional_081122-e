package javaProfessionalCourse2.lesson28.homework.tasks1;

import java.util.Random;

/*
3. Написать класс МФУ на котором возможны одновременная печать и сканирование документов,
при этом нельзя одновременно печатать два документа или сканировать (при печати
в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании
то же самое только "отсканировано...", вывод в консоль с периодом в 50 мс.)
 */
public class Exercise3 {
    public static void main(String[] args) {
        Mfu mfu = new Mfu();
        Random r = new Random();
        Thread threadPrint = new Thread(() -> {
            mfu.print(r.nextInt(10));
        });
        Thread threadScan = new Thread(() -> {
            mfu.scan(r.nextInt(10));
        });

            threadPrint.start();
            threadScan.start();
    }
}

class Mfu {
    private volatile boolean isReady;

    public Mfu() {
        isReady = true;
    }

    public synchronized void print(int count) {
        try {
            while (!isReady) {
                wait();
            }
            isReady = false;

            System.out.println("Печатаю ");
            for (int i = 0; i < count; i++) {
                System.out.print(i + ", ");
                Thread.sleep(50);
            }
            System.out.println("страниц");

            isReady = true;
            notify();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void scan(int count) {
        try {
            while (!isReady) {
                wait();
            }
            isReady = false;

                System.out.println("Сканирую ...");
            for (int i = 0; i < count; i++) {
                System.out.print(i + ", ");
                Thread.sleep(50);
            }
            System.out.println("страниц");

            isReady = true;
            notify();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}