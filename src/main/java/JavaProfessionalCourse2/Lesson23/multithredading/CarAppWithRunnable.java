package JavaProfessionalCourse2.Lesson23.multithredading;

public class CarAppWithRunnable {
    public static void main(String[] args) {
        var ferrari = new CarWithRunnable("Ferrari");
        var bmw = new CarWithRunnable("BMW");

        var ferrariThread = new Thread(ferrari, "Ferrari-Thread");
        var bmwThread = new Thread(bmw, "BMW-Thread");

        ferrariThread.start();
        bmwThread.start();

        System.out.println("Method continues excecution ... Main method is executed by thread " + Thread.currentThread().getName());
    }
}
