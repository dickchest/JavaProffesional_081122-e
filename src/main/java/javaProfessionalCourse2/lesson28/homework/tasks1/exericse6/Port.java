package javaProfessionalCourse2.lesson28.homework.tasks1.exericse6;
/*
6. Написать программу, моделирующую работу порта. Корабли могут заходить в порт
для разгрузки / загрузки контейнеров. Количество контейнеров, находящихся в текущий
момент в порту и на корабле, не должно превышать заданную грузоподъемность судна и
емкость порта. В порту работает несколько причалов. В одном причале может стоять
только один корабль. Корабль может загружаться у причала, разгружаться или выполнять оба действия.
 */

import java.util.concurrent.Semaphore;

public class Port {
    private int capacity = 100; // емкость порта
    Semaphore dockSemaphore; // семафор для контроля доступа к причалам

    public Port(int capacity, int docCount) {
        this.capacity = capacity;
        this.dockSemaphore = new Semaphore(docCount, true);
    }

    public void loadShip(int containers) {
        try {
            dockSemaphore.acquire(); // захват причала
            System.out.println("Загрузка корабля: " + containers + " контейнеров");
            // загрузка контейнеров на корабль
            Thread.sleep(1000); // имитация загрузки корабля
            System.out.println("Корабль загружен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            dockSemaphore.release();
        }
    }

    public void unloadShip(int containers) {
        try {
            dockSemaphore.acquire(); // захват причала
            System.out.println("Расгрузка корабля в порту: " + containers + " контейнеров");
            // расгрузка контейнеров с корабля
            Thread.sleep(1000); // имитация загрузки корабля
            System.out.println("Корабль разгружен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            dockSemaphore.release();
        }
    }
}
