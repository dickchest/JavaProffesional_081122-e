package javaProfessionalCourse2.lesson27.semaphore;

import java.util.concurrent.Semaphore;

public class SemApp {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        CommonResource res = new CommonResource();
        new Thread(new CountTread(res, sem, "countThread 1" )).start();
        new Thread(new CountTread(res, sem, "countThread 2" )).start();
        new Thread(new CountTread(res, sem, "countThread 3" )).start();
    }
}
