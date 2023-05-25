package javaProfessionalCourse2.lesson25.synchronizing;

public class Counter {
    private int counter = 0;

    public synchronized void increaseCounter() {
//        System.out.println(Thread.currentThread().getName());
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
