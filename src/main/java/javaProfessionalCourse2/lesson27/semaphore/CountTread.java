package javaProfessionalCourse2.lesson27.semaphore;

import java.util.concurrent.Semaphore;

public class CountTread implements Runnable{

    CommonResource res;
    Semaphore semaphore;
    String name;

    public CountTread(CommonResource res, Semaphore semaphore, String name) {
        this.res = res;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " ожидает получения разрешения ");
            semaphore.acquire();
            res.x = 1;
            for (int i = 0; i < 10; i++) {
                System.out.println(this.name + ": " + res.x);
                res.increment();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает полученное разрешение");
        semaphore.release();
    }
}
