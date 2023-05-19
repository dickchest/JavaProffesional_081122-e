package JavaProfessionalCourse2.Lesson23.multithredading;

public class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from a thread!" + Thread.currentThread().getName());
    }
}
