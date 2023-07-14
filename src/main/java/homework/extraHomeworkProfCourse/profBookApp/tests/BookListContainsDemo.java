package homework.extraHomeworkProfCourse.profBookApp.tests;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;

import java.util.ArrayList;
import java.util.List;

/*
Создайте класс BookListContainsDemo в котором продемонстрируйте как
делают проверку есть ли в списке книга или её нет с помощью метода
contains(). Если для правильной работы метода contains() требуется
внести изменения в класс Book, сделайте это!

 */
public class BookListContainsDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book("A1", "B1");
        Book book2 = new Book("A2", "B2");

        books.add(book1);
        books.add(book2);

        Book bookInTheList = new Book("A1", "B1");
        boolean containsBook = books.contains(bookInTheList); // должно быть true
        System.out.println(containsBook);

        Book bookNotInTheList = new Book("A3", "B3");
        boolean notContainsBook = books.contains(bookNotInTheList); // должно быть false
        System.out.println(notContainsBook);
    }
}
