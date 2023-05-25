package javaProfessionalCourse2.lesson24_threads_priority_interrupt.demo2;

public class DemoThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        var thread1 = new DemoThread2();
        DemoThread2 thread2 = new DemoThread2();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int result = thread1.getResult() + thread2.getResult();

        System.out.println("Total result = " + result);
    }
}
