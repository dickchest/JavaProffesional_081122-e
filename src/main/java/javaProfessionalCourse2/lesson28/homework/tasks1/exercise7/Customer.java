package javaProfessionalCourse2.lesson28.homework.tasks1.exercise7;

import java.util.*;

public class Customer implements Runnable {
    private String name;
    private Library library;
    private Set<Book> bookListToTakeOff;
    private Set<Book> bookListToRead;

    public String getName() {
        return name;
    }

    public Customer(String name, Library library) {
        this.name = name;
        bookListToTakeOff = new HashSet<>();
        bookListToRead = new HashSet<>();
        this.library = library;
    }

    public Set<Book> getBookListToTakeOff() {
        return bookListToTakeOff;
    }

    public Set<Book> getBookListToRead() {
        return bookListToRead;
    }

    public void setBookToTakeOff(Book book) {
        bookListToTakeOff.add(book);
    }

    public void setBookToRead(Book book) {
        bookListToRead.add(book);
    }

    public void printBorrowedBooks() {
        System.out.println("книги для чтения посетителя " + this.name);
        System.out.println(this.getBookListToRead());
        System.out.println("книги можно брать домой");
        System.out.println(this.getBookListToTakeOff());
    }

    @Override
    public void run() {
        Random random = new Random();
        int quantity = random.nextInt(2,10);
        System.out.printf("Посетитель %s хочет взять %d книг%n", this.name, quantity);
        for (int i = 0; i <= quantity; i++) {
            library.borrowTheBook(this, random.nextInt(library.numberOfBooks));
        }
        // должен случайным образом выбирать книгу
        // если книга не доступан, ждем пока осовободится
        // если книга доступна только для чтения, идем в читальный зал
    }


}
