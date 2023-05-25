package javaProfessionalCourse2.lesson24_threads_priority_interrupt.demo2;

public class DemoThread2 extends Thread{
    private int result;
    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        result = 0;
        for (int i = 0; i < 55; i++) {
            result ++;
        }
    }
}
