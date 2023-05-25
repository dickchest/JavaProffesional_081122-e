package javaProfessionalCourse2.lesson25.synchronisedExample;

public class Example2 {
    static int counter;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                counter = 0;
                for (int i = 0; i < 5; i++) {
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();





    }
}
