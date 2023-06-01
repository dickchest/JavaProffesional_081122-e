package javaProfessionalCourse2.lesson27.semaphore;

public class CommonResource {
    int x = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public synchronized void increment() {
        this.x++;
    }
}
