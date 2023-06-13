package javaProfessionalCourse2.lesson28.homework.tasks2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
Задача из логистики, как выбрать наиболее оптимальный путь
при доставке товаров
  A  _ _ _ _             _ _ _ _ B
            \          /
              - - E - -
    _ _ _ _ /          \ _ _ _ _
  C                              D

 E - точка обмена

 необходимо доставить посылки двумя грузовиками
 грузовик 1: посылка A -> C и A -> D
 грузовик 2: посылка B -> C и B -> D

 создать пункт E для обмена конечными посылками, чтобы итоговые конечные точки были одинаковые, то есть
 грузовик 1: посылка A -> C и A -> D, после обмена: A -> D и B -> D
 грузовик 2: посылка B -> C и B -> D, после обмена: B -> C и A -> C
 */
public class Exercise4 {
    /**
     * хотелось бы узнать, есть ли решение попроще )))
     * @param args
     */
    public static void main(String[] args) {
        // создаем товары
        List<Good> goods = List.of(
                new Good('A', 'C'),
                new Good('A', 'D'),
                new Good('B', 'C'),
                new Good('B', 'D')
        );
//        System.out.println(goods);

        // создаем екченджер
        Exchanger<List<Good>> exchanger = new Exchanger<>();

        // создаем барьер, что грузовики одновременно приехали в ключевые точки
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        // создаем поток грузовиков
        ExecutorService executors = Executors.newFixedThreadPool(2);

        executors.submit(new Truck(1, 'A', 'D',goods, exchanger, cyclicBarrier));
        executors.submit(new Truck(2, 'B', 'C', goods, exchanger,cyclicBarrier));

        executors.shutdown();

    }
}


class Truck implements Runnable {
    //    номер грузовика
    private int truckNumber;
    //    исходная точка
    private char currentPoint;
    //    точка назначения
    private char endPoint;

    //    промежуточная точка ????
    private char middlePoint;

    //    груз лист (класс груз, точка отправления и точка назначения
    // груз общий
    List<Good> goods;

    // груз для текущего грузовика
    List<Good> loadedGoods;
    //    ексченджер
    Exchanger<List<Good>> exchanger;
    // барьер
    CyclicBarrier cyclicBarrier;

    public Truck(int truckNumber, char currentPoint, char endPoint,  List<Good> goods, Exchanger<List<Good>> exchanger, CyclicBarrier cyclicBarrier) {
        this.truckNumber = truckNumber;
        this.currentPoint = currentPoint;
        this.endPoint = endPoint;
        this.middlePoint = 'E';
        this.goods = goods;
        this.exchanger = exchanger;
        this.cyclicBarrier = cyclicBarrier;
        loadedGoods = new ArrayList<>();
    }

    private static void threadSleep(int duration) { // вывел в метод метод sleep
        try {
            for (int i = 0; i < 10; i++) {
            Thread.sleep(duration/10);
                System.out.print(".");

            }
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
// определяем, какие товары нужно взять данному грузовику
        for (Good item : goods) {
            if (item.getFirstPoint() == currentPoint) {
                // загружаем товар
                item.setLoaded(true);
                loadedGoods.add(item);
            }
        }
        System.out.println("Грузовик " + truckNumber + " загрузился товарами: " + loadedGoods);

        // доезжаем до пункта обмена
        threadSleep(3000);
        // ждем все потоки
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
//        System.out.println("поехали дальше");
        currentPoint = 'E';
        // готовим список для обмена
        List<Good> goodsForChange = new ArrayList<>();
        // решаем, какие товары обменять
        for (Good item : goods) {
            if (item.getLastPoint() != endPoint) {
                goodsForChange.add(item);
                loadedGoods.remove(item);
            }
        }
        System.out.println("На грузовике "+ truckNumber +" товары готовы к обмену: " + goodsForChange);
        // производим обмен
        try {
            goodsForChange = exchanger.exchange(goodsForChange);
            System.out.println("Грузовик "+ truckNumber + " получили товары:" + goodsForChange);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // доезжаем до последней точки
        threadSleep(3000);
        // ждем все потоки
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        for (Good item : goodsForChange) {
            System.out.printf("Товар %s доставлен в точку %s на грузовике %d\n", item.getGoodNumber(), endPoint, truckNumber);
        }
    }
}


// класс груз
class Good {
    private static int counter = 0;
    private int goodNumber;
    private char firstPoint;
    private char lastPoint;
    private boolean isLoaded;

    public Good(char firstPoint, char lastPoint) {
        counter++;
        goodNumber = counter;
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.isLoaded = false;
    }

    public int getGoodNumber() {
        return goodNumber;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public char getFirstPoint() {
        return firstPoint;
    }

    public char getLastPoint() {
        return lastPoint;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodNumber=" + goodNumber +
                ", firstPoint=" + firstPoint +
                ", lastPoint=" + lastPoint +
                ", isLoaded=" + isLoaded +
                '}';
    }
}
