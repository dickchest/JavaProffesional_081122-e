package javaProfessionalCourse2.lesson25.synchronizing;

public class CounterThread extends Thread{
    private final Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
//        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
        }
//        System.out.println(Thread.currentThread().getName() + " finished");

    }
}
