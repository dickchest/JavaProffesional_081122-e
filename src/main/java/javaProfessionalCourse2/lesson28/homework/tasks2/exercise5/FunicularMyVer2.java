package javaProfessionalCourse2.lesson28.homework.tasks2.exercise5;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicBoolean;

/*
5)	Написать программу эмуляции работы фуникулера.
Дан фуникулер, который поднимает людей на вершину холма,
он может перевести ограниченное количество людей, например 2.
На платформу приходит много людей, но фуникулер перевозит только двоих.
Вывести информацию о текущем действии фуникулера.
Перевезти всех пассажиров на вершину холма с помощью нашего фуникулера.

Разработать универсальный сценарий - количество людей четное или нечетное.
 */
public class FunicularMyVer2 {
    // допустмое кол-во людей в фуникулере
    private final static int MAX_PAX = 2;
    // действия фуникулера
    private static String OPEN_DOOR = " door is opened";
    private static String CLOSE_DOOR = " door is closed";
    private static String WAIT = " waiting";
    private static String ENTER = " enter the cabin";
    private static String EXIT = " exit the cabin";
    private static String ARRIVE = " train gets to station # ";

    static int paxQuantity = new Random().nextInt(2, 10);
    public static void main(String[] args) {
        // Екзекьютор сервис = для формирования потоков-пассажиров
        System.out.println("Total amount of pax: " + paxQuantity);
        ExecutorService paxExecutor = Executors.newFixedThreadPool(paxQuantity);
        // Файзер = для формирования фаз прохождения
        Phaser phaser = new Phaser(1) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                // Метод, вызываемый при завершении каждой фазы
                System.out.println("Фаза из эдвенса: " + phase + " завершена");
                return false;
            }
        };

        Runnable task = () -> {
            // Пассажир приходит на платформу и ожидает
            while (phaser.getRegisteredParties() > MAX_PAX || phaser.getPhase() % 2 != 0) {
//                System.out.println(phaser.getRegisteredParties());
//                sleepTread(200);
            }
//            System.out.println(phaser.getPhase() + " зареригено " + phaser.getRegisteredParties());

            phaser.register();
            System.out.println(phaser.getPhase() + " зареригено " + phaser.getRegisteredParties());
            System.out.println(Thread.currentThread().getName() + " пришел на платформу на фазе " + phaser.getPhase());
            // заходит в фуникуляер
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + ENTER);

            // подьезжаем к конечно точке
            // Пассажир выходит и выходит из фазера
//            phaser.arriveAndAwaitAdvance();
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + EXIT);
//            phaser.arriveAndDeregister();
            System.out.println("вышел на фазе" + phaser.getPhase());
//            phaser.arriveAndDeregister();
            paxQuantity--;
            System.out.println("Числа пасико: " + paxQuantity);

        };

        // формирование пассажиров
        for (int i = 0; i < paxQuantity; i++) {
            // что бы эта версия работала нужно создать 5 фаз и подключать потоки на фазах, кратные пяти
            paxExecutor.execute(task);
        }


        while(paxQuantity > 0) {
            // фуникулер подьезжаем к начальной точке
            arriving(phaser, OPEN_DOOR);
            // фуникулер подьезжаем к конечной точке
            arriving(phaser, EXIT);
            // возвращаемся назад

            sleepTread(2000);

//            phaser.arriveAndAwaitAdvance();
            phaser.bulkRegister(1);
        }
            paxExecutor.shutdown();
    }

    private static void arriving(Phaser phaser, String action) {
        // подьезжаем к станции
        System.out.println(ARRIVE + phaser.getPhase());

        // октрываем двери
        System.out.println(OPEN_DOOR + " фаза " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        sleepTread(1500);

        // закрываем двери
        System.out.println(CLOSE_DOOR);
        sleepTread(1500);
    }

    public static void sleepTread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
