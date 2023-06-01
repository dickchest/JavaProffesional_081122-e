package javaProfessionalCourse2.lesson26.synchExample5.semaphore;

import java.util.concurrent.Semaphore;

public class SemApp {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        CommonResource res = new CommonResource();
        new Thread(new CountTread(res, sem, "countThread 1" )).start();
        new Thread(new CountTread(res, sem, "countThread 2" )).start();
        new Thread(new CountTread(res, sem, "countThread 3" )).start();
    }
}
