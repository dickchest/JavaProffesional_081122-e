package javaProfessionalCourse2.lesson25.interrupt;

import javaProfessionalCourse2.lesson23_multitreading.multithredading.ThreadExampleWithLambda;

public class InterruptedExample5 implements Runnable{

    private boolean stop;



    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                stop = true;
            }
        }
    }

    public void stopThread() {
        stop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptedExample5 ie = new InterruptedExample5();
        Thread thread = new Thread(ie);
        thread.start();

        Thread.sleep(5000);

        ie.stopThread(); // 1й вариант
        thread.interrupt(); // 2й вариант
    }

}
