package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

public class PrintAllBooksUIAction implements UIAction {
    private BookDatabase bookDatabase;

    public PrintAllBooksUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        bookDatabase.print();
    }

    @Override
    public String getActionName() {
        return "Print All Books";
    }
}
