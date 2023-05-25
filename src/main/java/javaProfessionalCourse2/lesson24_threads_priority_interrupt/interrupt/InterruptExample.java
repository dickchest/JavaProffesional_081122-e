package javaProfessionalCourse2.lesson24_threads_priority_interrupt.interrupt;

public class InterruptExample {
    public static void main(String[] args) {
        Thread tr = new Thread(() -> {
            boolean flag = true;

            while (flag) {
//            while (Thread.currentThread().isInterrupted() == false) {
                System.out.println("working ...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Exception");
                    flag = false;
//                    Thread.currentThread().interrupt();
                }
            }

        });

        tr.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tr.interrupt(); // меняет флаг с false на true

    }
}
