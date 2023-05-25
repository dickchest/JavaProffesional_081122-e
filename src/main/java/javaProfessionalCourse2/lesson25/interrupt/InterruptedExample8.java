package javaProfessionalCourse2.lesson25.interrupt;

public class InterruptedExample8 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
                // восстанавливаем флаг прерывания
                Thread.currentThread().interrupt();
            }
        });

        thread.start();
        // прерываем поток через 5000 миллисекунд, если он еще не завершился

        Thread.sleep(5000);

        if (thread.isAlive()) {
            thread.interrupt();
        }
    }
}