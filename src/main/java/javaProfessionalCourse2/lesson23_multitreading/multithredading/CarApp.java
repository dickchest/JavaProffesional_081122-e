package javaProfessionalCourse2.lesson23_multitreading.multithredading;

public class CarApp {
    public static void main(String[] args) {
        var ferrari = new Car("Ferrari");
        var bmw = new Car("BMW");
        ferrari.start();
        bmw.start();

        System.out.println("Method continues excecution ... Main method is executed by thread " + Thread.currentThread().getName());
    }
}
