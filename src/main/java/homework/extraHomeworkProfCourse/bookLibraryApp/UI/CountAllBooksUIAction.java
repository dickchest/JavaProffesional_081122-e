package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.Scanner;

public class CountAllBooksUIAction implements UIAction {
    private BookDatabase bookDatabase;

    public CountAllBooksUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        System.out.println("Total books: " + bookDatabase.countAllBooks());
    }

    @Override
    public String getActionName() {
        return "Count All Books";
    }
}
