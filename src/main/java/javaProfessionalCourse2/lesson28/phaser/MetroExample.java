package javaProfessionalCourse2.lesson28.phaser;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class MetroExample {
    private static Phaser PHASER;
    private static String OPEN = "     открытие дверей ";
    private static String CLOSE = "     закрытие дверей ";
    private static String WAIT = " ждёт на станции ";
    private static String ENTER = " вошел в вагон ";
    private static String EXIT = " вышел из вагона ";
    private static String SPACE = "    ";


    public static void main(String[] args) {

        // Регстрация обекта синхронизации
        PHASER = new Phaser(1);

        ArrayList<Passenger> passengers = new ArrayList<>();

        // Формирование массива пассажиров
        for (int i = 1; i < 5; i++) {
            if ((int) (Math.random() * 2) > 0)
                // этот пассажир проезжает одну станцию
                passengers.add(new Passenger("Passenger" + i, i, i + 1));
            if ((int) (Math.random() * 2) > 0) {
                // Этот пассажир едет до конечной
                Passenger p = new Passenger("Passenger" + 10 + i, i, 5);
                passengers.add(p);
            }
        }

        // Фазы 0 и 6 - конечные станции
        // Фазы 1...5 - промежуточные станции

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println("Метро вышло из тупика");
                    // нулевая фаза - участников нет
                    PHASER.arrive();
                case 6:
                    // Завершаем синхронизацию
                    System.out.println("Метро ушло в тупик");
                    PHASER.arriveAndDeregister();
                default:
                    int currentStation = PHASER.getPhase();
                    System.out.println("Станция " + currentStation);
                    // Проверка наличия пассажиров
                    // на станции
                    for (Passenger pass : passengers) {
                        if (pass.departure == currentStation) {
                            // регистрация участника
                            PHASER.register();
                            new Thread(pass).start();
                        }
                    }
                    System.out.println(OPEN);

                    // Phaser ожидает заершения операции всеми участинками
                    PHASER.arriveAndAwaitAdvance();

                    System.out.println(CLOSE);
            }
        }

    }

    public static class Passenger implements Runnable {
        String id;
        int departure;
        int destination;

        public Passenger(String id, int departure, int destination) {
            this.id = id;
            this.departure = departure;
            this.destination = destination;
            System.out.println(id + WAIT + departure);
        }

        @Override
        public void run() {
            try {
                System.out.println(SPACE + this + ENTER);
                //-----------------------------------------------
                // Заявляем об участии и ждем станции назначения
                while (PHASER.getPhase() < destination) {
                    PHASER.arriveAndAwaitAdvance();
                }
                //-----------------------------------------------
                Thread.sleep(200);
                System.out.println(SPACE + this + EXIT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
