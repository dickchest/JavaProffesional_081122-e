package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;
import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.Scanner;

public class SaveBookUIAction implements UIAction{

    private BookDatabase bookDatabase;

    public SaveBookUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        // запросите все данные о книге с консоли у пользолвателя
        // создайте экземпляр класса Book (не указывая поле id, его присвоит сама база данных)
        // сохраните его в базу данных: bookDatabase.save(book);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Title");
        String title = scanner.nextLine();

        System.out.println("Enter book Author");
        String author = scanner.nextLine();

        System.out.println("Enter book Year");
        String year = scanner.nextLine();

        bookDatabase.save(new Book(title, author, year));
    }

    @Override
    public String getActionName() {
        return "Save Book";
    }
}
