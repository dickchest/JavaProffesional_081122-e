package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.Scanner;

public class FindByTitleUIAction implements UIAction{
    private BookDatabase bookDatabase;

    public FindByTitleUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Title:");
        String author = scanner.nextLine();
        System.out.println(bookDatabase.findByTitle(author));

    }

    @Override
    public String getActionName() {
        return "Find by Title";
    }
}
