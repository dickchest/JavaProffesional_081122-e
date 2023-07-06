package homework.extraHomeworkProfCourse.bookLibraryApp.tests;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;
import homework.extraHomeworkProfCourse.bookLibraryApp.search.*;
import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabaseImpl;

public class BookDatabaseDemo {
    public static void main(String[] args) {

        BookDatabaseImpl books = new BookDatabaseImpl();
        Book book1 = new Book("A1", "B1","1992");
        Book book2 = new Book("A2", "B2", "1992");
        Book book3 = new Book("A3", "B2", "2000");

        System.out.println("Create books DB");
        System.out.println("Book save. Id:" + books.save(book1));
        System.out.println("Book save. Id:" + books.save(book2));
        books.print();

        System.out.print("Delete with id 1: ");
        System.out.println(books.delete(1L));
        System.out.println("Deleting books by book: ");
        System.out.println(books.delete(book1));
        System.out.println(books.delete(book2));

        books.save(book1);
        books.save(book2);
        books.save(book3);

        System.out.println("Finding books by ID: ");
        System.out.println(books.findById(1L));
        System.out.println(books.findById(3L));

        System.out.println("Finding books by Author: ");
        System.out.println(books.findByAuthor("B1"));
        System.out.println(books.findByAuthor("B2"));

        System.out.println("Finding books by Title: ");
        System.out.println(books.findByTitle("B2"));
        System.out.println(books.findByTitle("A2"));

        System.out.print("Count all books: ");
        System.out.println(books.countAllBooks());

        System.out.println("Deleting books by Author: ");
        books.deleteByAuthor("B2");
        books.print();

        System.out.println("Deleting books by Title: ");
        books.deleteByTitle("B2");
        books.deleteByTitle("A1");
        books.print();

        System.out.println("-------------------");
        // для тестов создае экземпляры search criteria
        SearchCriteria searchByAuthor = new AuthorSearchCriteria("B1");
        SearchCriteria searchByTitle = new TitleSearchCriteria("A2");
        SearchCriteria searchByYear = new YearOfIssueSearchCriteria("1992");
        SearchCriteria andSearchCriteria = new AndSearchCriteria(searchByAuthor, searchByYear);
        SearchCriteria orSearchCriteria = new OrSearchCriteria(searchByAuthor, searchByYear);

        books.save(book1);
        books.save(book2);
        books.save(book3);
        Book book4 = new Book("A1", "B1","1992");

        System.out.println("Search books by Author criteria: ");
        System.out.println(books.find(searchByAuthor));

        System.out.println("Search books by Title criteria: ");
        System.out.println(books.find(searchByTitle));

        System.out.println("Search books by Year criteria: ");
        System.out.println(books.find(searchByYear));

        System.out.println("Search books by complex and criteria: ");
        System.out.println(books.find(andSearchCriteria));

        System.out.println("If DB contains book:");
        System.out.println(books.contains(book1));
        System.out.println(books.contains(book4));
        books.save(book4);

        System.out.println("Grouping by Author:");
        System.out.println(books.getAuthorToBooksMap());

        System.out.println("Grouping by Author's book count:");
        System.out.println(books.getEachAuthorBookCount());
    }
}
