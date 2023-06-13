package javaProfessionalCourse2.lesson28.homework.tasks1.exericse6;

public class Ship implements Runnable{
    private String name;
    private int сapacityToLoad;
    private int сapacityToUnload;
    Port port;

    public Ship(String name, int capacityToLoad, int capacityToUnload, Port port) {
        this.name = name;
        this.сapacityToLoad = capacityToLoad;
        this.сapacityToUnload = capacityToUnload;
        this.port = port;
    }

    @Override
    public void run() {
        // загрузка корабля
        port.loadShip(сapacityToLoad);

        // разгрузка корабля
        port.unloadShip(сapacityToUnload);
        System.out.printf("На корабле %s загружено %d и разгружено %d контейнеров\n", name, сapacityToLoad, сapacityToUnload);
    }
}
