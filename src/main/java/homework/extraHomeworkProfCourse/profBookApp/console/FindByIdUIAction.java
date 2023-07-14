package homework.extraHomeworkProfCourse.profBookApp.console;

import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabase;

import java.util.Scanner;

public class FindByIdUIAction implements UIAction {
    private BookDatabase bookDatabase;

    public FindByIdUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        // запросите id книги с консоли у пользолвателя
        // поиск книги в базе данных: Optional<Book> bookOpt = bookDatabase.findById(id);
        // вывелите на консоль результаты поиска

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book id");
        Long id = scanner.nextLong();
        System.out.println(bookDatabase.findById(id));

    }

    @Override
    public String getActionName() {
        return "Find by Id";
    }
}
