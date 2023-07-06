package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.Scanner;

public class DeleteByIdUIAction implements UIAction{
    private BookDatabase bookDatabase;

    public DeleteByIdUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book id:");
        Long id = scanner.nextLong();
        System.out.println(bookDatabase.delete(id));

    }

    @Override
    public String getActionName() {
        return "Delete By ID";
    }
}
