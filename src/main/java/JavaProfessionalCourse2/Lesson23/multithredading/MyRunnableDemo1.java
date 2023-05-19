package JavaProfessionalCourse2.Lesson23.multithredading;

public class MyRunnableDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable1());

        thread.start();
    }
}
