package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;
import java.util.Scanner;

public class FindByAuthorUIAction implements UIAction{
    private BookDatabase bookDatabase;

    public FindByAuthorUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Author:");
        String author = scanner.nextLine();
        System.out.println(bookDatabase.findByAuthor(author));

    }

    @Override
    public String getActionName() {
        return "Find By Author";
    }
}
