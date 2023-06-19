package javaProfessionalCourse2.lesson28.synchronizedExtra;

public class synchronizedObject {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread()).start();
        }

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(MyThread.getCount());
    }

    public static class MyThread implements Runnable {
        final Object lock = new Object();
        static int count = 0;

        public MyThread() {
        }


        public static int getCount() {
            return count;
        }

        @Override
        public void run() {
            count++;
        }
    }
}
