package javaProfessionalCourse2.lesson24_threads_priority_interrupt.daemonExample2;

public class DatabaseServer implements Runnable{
    @Override
    public void run() {
        while (true) {
            // сохдраняем изменения в базу данных
            // ждем 10 минут
            try {
                Thread.sleep(600_000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
