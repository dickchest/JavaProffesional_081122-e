package javaProfessionalCourse2.lesson24_threads_priority_interrupt.daemonExample2;

public class HttpConnector implements Runnable{
    @Override
    public void run() {
        while (true) {
            // делает запрос по http протоколу по адресу ip
            // ждем 5 минут
            // если ответ не пустой, то положил в коллекци
            // и ждет еще 5 минут
            try {
                Thread.sleep(300_000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
