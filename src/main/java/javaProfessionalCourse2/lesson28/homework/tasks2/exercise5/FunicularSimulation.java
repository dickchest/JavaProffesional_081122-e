package javaProfessionalCourse2.lesson28.homework.tasks2.exercise5;

import java.util.concurrent.Phaser;

public class FunicularSimulation {

    public static void main(String[] args) {
        int totalPassengers = 10; // Общее количество пассажиров
        int capacity = 2; // Вместимость фуникулера

        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                // Метод, вызываемый при завершении каждой фазы
                System.out.println("Фаза " + phase + " завершена");
                return registeredParties == 0;
            }
        };

        for (int i = 0; i < totalPassengers; i++) {
            Thread thread = new Thread(() -> {
                // Пассажир приходит на платформу и ожидает
                System.out.println("Пассажир пришел на платформу");
                phaser.arriveAndAwaitAdvance(); // Ожидание остальных пассажиров на этой фазе

                // Пассажир садится в фуникулер
                System.out.println("Пассажир сел в фуникулер");
                phaser.arriveAndAwaitAdvance(); // Ожидание остальных пассажиров на этой фазе

                // Фуникулер поднимает пассажиров на вершину холма
                System.out.println("Фуникулер поднимается на вершину холма");


                phaser.arriveAndDeregister(); // Пассажир завершил свою работу и выходит из фазера
            });
            while (phaser.getRegisteredParties() > 1) {
                // ждем
            }
                phaser.register(); // Регистрация пассажира в фазере
                thread.start();
        }

        // Ожидание завершения всех фаз
        while (!phaser.isTerminated()) {
            // Ждем завершения фаз
        }

        System.out.println("Все пассажиры доставлены на вершину холма");
    }
}