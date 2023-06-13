package javaProfessionalCourse2.lesson28.homework.tasks1.exericse6;

public class PortSimulator {
    public static void main(String[] args) {
        Port port = new Port(100, 3);

        Ship ship1 = new Ship("Ship 1", 50, 30, port);
        Ship ship2 = new Ship("Ship 2", 70, 60, port);
        Ship ship3 = new Ship("Ship 3", 80, 20, port);
        Ship ship4 = new Ship("Ship 4", 50, 20, port);

        new Thread(ship1).start();
        new Thread(ship2).start();
        new Thread(ship3).start();
        new Thread(ship4).start();
    }
}
