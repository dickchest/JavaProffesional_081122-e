package javaProfessionalCourse2.lesson28.homework.tasks1.exercise7;

import java.util.concurrent.Semaphore;

public class Book {
    private int idBook;
    private String name;

    private volatile boolean isAvailable;
    final private boolean isPermittedToTakeOff;

    public Book(int idBook, String name, boolean isAvailable, boolean isPermittedToTakeOff) {
        this.idBook = idBook;
        this.name = name;
        this.isAvailable = isAvailable;
        this.isPermittedToTakeOff = isPermittedToTakeOff;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isPermittedToTakeOff() {
        return isPermittedToTakeOff;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", isAvailable=" + isAvailable +
                ", isPermittedToTakeOff=" + isPermittedToTakeOff +
                '}';
    }
}
