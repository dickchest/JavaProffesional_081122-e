package javaProfessionalCourse2.lesson24_threads_priority_interrupt.demo1;

public class CountDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterRunnable(counter));
        Thread thread2 = new Thread(new CounterRunnable(counter));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

//        Thread.sleep(1000);
        System.out.println("Count = " + counter.getCount());


    }
}
