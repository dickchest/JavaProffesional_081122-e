package homework.extraHomeworkProfCourse.profBookApp.tests;

import homework.extraHomeworkProfCourse.profBookApp.console.DeleteByIdUIAction;
import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabaseImpl;

public class UITests {
    public static void main(String[] args) {
        BookDatabaseImpl books = new BookDatabaseImpl();
        Book book1 = new Book("A1", "B1", "1992");
        Book book2 = new Book("A2", "B2", "1992");
        Book book3 = new Book("A3", "B2", "2000");
        Book book4 = new Book("A4", "B1", "1992");
        books.save(book1);
        books.save(book2);
        books.save(book3);
        books.save(book4);

        books.print();
//        new FindByTitleUIAction(books).execute();
//        new DeleteByIdUIAction(books).execute();
        books.print();


    }
}
