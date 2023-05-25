package javaProfessionalCourse2.lesson24_threads_priority_interrupt.priorityExample;

public class PriorityDemo2 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new Thread(() -> {
            System.out.println("user thread 1 is running");
            Thread.currentThread().setName("My name 1");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("user thread 2 is running");
            Thread.currentThread().setName("My name 2");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
        });

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
