package javaProfessionalCourse2.lesson25.synchronizing;

public class CounterTester {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }

        Thread.sleep(10);

        System.out.println("Counter = " + counter.getCounter());
    }
}
