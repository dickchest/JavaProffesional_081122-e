package javaProfessionalCourse2.lesson24_threads_priority_interrupt.daemon;

public class DaemonApp {
    public static void main(String[] args) {


        var worker = new Thread(() -> {
            while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            var threadName = Thread.currentThread().getName();
            System.out.println("thread name is executing: " + threadName);}
        }, "Worker");


        var daemon = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                var threadName = Thread.currentThread().getName();
                System.out.println("thread name is executing: " + threadName);
            }
        }, "Daemon");


        daemon.setDaemon(true); // сразу получили 2 отличия от других потоков
//        метод работает с минимальным приоритетом в фоновом режиме
//        как только у нас завершают другие потоки, то джава автоматически погасит работу потока демона
        worker.start();
        daemon.start();

        var threadName = Thread.currentThread().getName();
        System.out.println("thread name is executing: " + threadName);


    }
}
