package javaProfessionalCourse2.lesson28.phaser;

import java.util.concurrent.Phaser;

public class PhaserThreadExample {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        System.out.println(phaser.getRegisteredParties());

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        System.out.println(phaser.toString());
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        System.out.println(phaser.toString());
        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        System.out.println(phaser.toString());
        phaser.arriveAndDeregister();
    }
}
