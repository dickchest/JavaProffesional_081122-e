package javaProfessionalCourse2.lesson24_threads_priority_interrupt.daemonExample2;

public class DataBaseUtil {
    public static void main(String[] args) {
        DatabaseServer dbs = new DatabaseServer();
        Thread thread = new Thread(dbs);
        thread.setDaemon(true);
        thread.start();

        HttpConnector hc = new HttpConnector();
        Thread thread2 = new Thread(hc);
        thread.setDaemon(true);
        thread.start();


    }
}
