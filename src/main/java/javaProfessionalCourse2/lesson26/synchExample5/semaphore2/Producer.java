package javaProfessionalCourse2.lesson26.synchExample5.semaphore2;

public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.put();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
