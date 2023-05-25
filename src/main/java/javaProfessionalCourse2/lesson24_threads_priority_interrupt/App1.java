package javaProfessionalCourse2.lesson24_threads_priority_interrupt;

public class App1 {
    public static void main(String[] args) throws InterruptedException {
        var threadTwo = new Thread(() -> {
            try {
                Thread.sleep(2000);
                int counter = 0;
                for (int i = 0; i < 1000; i++) {
                    counter++;
                }
                var thread = Thread.currentThread().getName();
                System.out.println(thread + " has finished its execution, counter =" + counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Counter thread");

        threadTwo.start();
        threadTwo.join();

        System.out.println("Main method executed");
    }
}
