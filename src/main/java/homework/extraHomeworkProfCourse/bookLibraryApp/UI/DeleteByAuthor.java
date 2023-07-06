package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.Scanner;

public class DeleteByAuthor implements UIAction{
    private BookDatabase bookDatabase;

    public DeleteByAuthor(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Author:");
        String author = scanner.nextLine();
        bookDatabase.deleteByAuthor(author);
    }

    @Override
    public String getActionName() {
        return "Delete By Author";
    }
}
