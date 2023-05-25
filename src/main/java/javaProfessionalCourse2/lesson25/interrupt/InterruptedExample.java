package javaProfessionalCourse2.lesson25.interrupt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterruptedExample {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (Thread.interrupted()) {
                        System.out.println("Interrupted! ");
                        break;
                    }
                    System.out.println("Read: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "My tread");

        thread.start();
        Thread.sleep(5000);

        thread.interrupt();

    }
}
