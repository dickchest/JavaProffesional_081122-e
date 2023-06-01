package javaProfessionalCourse2.lesson26.synchExample5.semaphore2;

public class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.get();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
