package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.Scanner;

public class DeleteByTitle implements UIAction{
    private BookDatabase bookDatabase;

    public DeleteByTitle(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Title:");
        String title = scanner.nextLine();
        bookDatabase.deleteByTitle(title);
    }

    @Override
    public String getActionName() {
        return "Delete By Title";
    }
}
