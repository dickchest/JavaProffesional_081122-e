package javaProfessionalCourse2.lesson24_threads_priority_interrupt.demo1;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
