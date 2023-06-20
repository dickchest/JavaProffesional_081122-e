package javaProfessionalCourse2.lesson28.homework.tasks1.exercise7;

import java.util.*;

public class Library {
    int numberOfBooks = 20;
    List<Book> books;
    Set<Customer> customers;

    public Library() {
        // заполняем библиоетку книгами
        Random random = new Random();
        books = new ArrayList<>();
        for (int i = 0; i < numberOfBooks; i++) {
            books.add(new Book(i, "Book " + i, true, random.nextBoolean()));
        }
        customers = new HashSet<>();
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public synchronized void borrowTheBook(Customer customer, int idBook) {
        Book book = getBook(idBook);
        if (!book.isAvailable()) {
            if (customer.getBookListToRead().contains(book)) {
                System.out.println("вы уже взяли эту книгу");
            }
            System.out.println("книга " + idBook + " не доступна, нужно ждать");
            return;
        }
        book.setAvailable(false);
        if (book.isPermittedToTakeOff()) {
            customer.setBookToTakeOff(book);
        } else {
            customer.setBookToRead(book);
        }
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void returnBook (Customer customer, int idBook) {
        Book book = getBook(idBook);
        book.setAvailable(true);
        System.out.printf("Книга %s возвращена", book.getIdBook());
    }

    private Book getBook(int idBook){
        // дописать условие, если книги нет
        return books.get(idBook);
    }
}
