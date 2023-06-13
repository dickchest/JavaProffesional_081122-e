package javaProfessionalCourse2.lesson28.homework.tasks2.exercise5;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/*
5)	Написать программу эмуляции работы фуникулера.
Дан фуникулер, который поднимает людей на вершину холма,
он может перевести ограниченное количество людей, например 2.
На платформу приходит много людей, но фуникулер перевозит только двоих.
Вывести информацию о текущем действии фуникулера.
Перевезти всех пассажиров на вершину холма с помощью нашего фуникулера.

Разработать универсальный сценарий - количество людей четное или нечетное.
 */
public class FunicularMyVer1 {
    // допустмое кол-во людей в фуникулере
    private final static int MAX_PAX = 2;
    // действия фуникулера
    private static String OPEN_DOOR = " door is opened";
    private static String CLOSE_DOOR = " door is closed";
    private static String WAIT = " waiting";
    private static String ENTER = " enter the cabin";
    private static String EXIT = " exit the cabin";
    private static String ARRIVE = " train gets to station # ";

    public static void main(String[] args) {
        // Екзекьютор сервис = для формирования потоков-пассажиров
        int paxQuantity = new Random().nextInt(1, 10);
        System.out.println("Total amount of pax: " + paxQuantity);
        ExecutorService paxExecutor = Executors.newFixedThreadPool(paxQuantity);
        // Файзер = для формирования фаз прохождения
        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                // Метод, вызываемый при завершении каждой фазы
//                System.out.println("Фаза из эдвенса: " + phase + " завершена");
                return false;
            }
        };

        // формирование пассажиров
        for (int i = 0; i < paxQuantity; i++) {
            Runnable task = () -> {
                // Пассажир приходит на платформу и ожидает
                System.out.println(Thread.currentThread().getName() + " пришел на платформу");

                // подьезжаем к начальной точке
                arriving(phaser, ENTER);

                // подьезжаем к конечно точке
                // Пассажир завершил свою работу
                System.out.println("Фуникулер поднимается на вершину холма");
                arriving(phaser, EXIT);

                //  и выходит из фазера
                // возвращаемся назад
                System.out.println("Train goes back to the start point");
                phaser.arriveAndDeregister();
                sleepTread(2000);

            };
            // ждем, пока фуникулер будет готов принять поссажиров
            while (phaser.getRegisteredParties() >= 2) {
                sleepTread(1000);
            }
            phaser.register();
            paxExecutor.execute(task);
        }
        paxExecutor.shutdown();


    }

    private static void arriving(Phaser phaser, String action) {
        // подьезжаем к станции
        System.out.println(ARRIVE);
        phaser.arriveAndAwaitAdvance();

        // октрываем двери
        System.out.println(OPEN_DOOR);


        // Пассажир производит действие в фуникулере
        System.out.println("Пассажир " + Thread.currentThread().getName() + action);
        sleepTread(1000);

        // закрываем двери
        System.out.println(CLOSE_DOOR);
        sleepTread(2000);
    }

    public static void sleepTread(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
