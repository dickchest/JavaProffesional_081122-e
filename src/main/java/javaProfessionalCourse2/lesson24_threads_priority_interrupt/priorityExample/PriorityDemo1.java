package javaProfessionalCourse2.lesson24_threads_priority_interrupt.priorityExample;

public class PriorityDemo1 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(8);
        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("My name");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getPriority());
            }
        };
        thread.start();
    }
}
