package javaProfessionalCourse2.lesson26.synchExample5.semaphore2;

import java.util.concurrent.Semaphore;

public class Store {
    private int product = 0;
    private Semaphore producerSemaphore = new Semaphore(1);
    private Semaphore consumerSemaphore = new Semaphore(0);

    public void get() {
        try {
            consumerSemaphore.acquire();
            product--;
            System.out.println("Покупатель купил один товар");
            System.out.println("Товаров на складе: " + product);
            producerSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void put() {
        try {
            producerSemaphore.acquire();
            product++;
            System.out.println("Производитель добавил один товар");
            System.out.println("Товаров на складе: " + product);
            if (product < 5) {
                consumerSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
