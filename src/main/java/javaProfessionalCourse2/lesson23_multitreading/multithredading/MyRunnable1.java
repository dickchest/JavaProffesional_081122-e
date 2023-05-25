package javaProfessionalCourse2.lesson23_multitreading.multithredading;

public class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from a thread!" + Thread.currentThread().getName());
    }
}
