package javaProfessionalCourse2.lesson23_multitreading.multithredading;

public class MyRunnableDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable1());

        thread.start();
    }
}
