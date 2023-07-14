package homework.extraHomeworkProfCourse.profBookApp.console;

import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabase;

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
