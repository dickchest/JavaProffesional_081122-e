package javaProfessionalCourse2.lesson28.homework.tasks1;

import javaProfessionalCourse2.lesson28.atomic.AtomicExample;

import java.util.concurrent.atomic.AtomicInteger;

/*
5. Написать класс Counter, в котором есть одно целочисленное поле count (инициализировано нулем).
В классе реализовать два метода add и sub. Первый метод увеличивает значение count на 1,
второй - уменьшает на 1. Запустить два потока: в первом в цикле (можно 100 раз) вызвать
метод add, во втором потоке столько же раз вызвать метод sub. В цикле, после каждой итерации,
лучше поставить Thread.sleap, чтобы лучше смоделировать ситуацию. Добиться синхронизацией потоков,
чтобы значение count после всех операций было равно 0. Пример, одного потока:
Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.add();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

 */
public class Exercise5 {
    public static void main(String[] args) {
        Count count = new Count();

        Thread thread1 = new Thread(() -> {
            count.add();
//            System.out.println(count.getCount());
        });

        Thread thread2 = new Thread(()-> {
            count.sub();
//            System.out.println(count.getCount());
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count.getCount());
    }
}
class Count {
    private AtomicInteger count;

    public Count() {
        count = new AtomicInteger(0);
    }

    public int getCount() {
        return count.get();
    }

    public void add() {
        for (int i = 0; i < 100; i++) {
            count.getAndIncrement();
//            System.out.println(count.get());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sub() {
        for (int i = 0; i < 100; i++) {
            count.getAndDecrement();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}