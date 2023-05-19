package JavaProfessionalCourse2.Lesson23.multithredading;

public class ThreadExampleWithLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread is running"));

        thread.start();
    }
}
