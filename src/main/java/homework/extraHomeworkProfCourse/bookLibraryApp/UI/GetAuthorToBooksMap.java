package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;
import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GetAuthorToBooksMap implements UIAction{
    private BookDatabase bookDatabase;

    public GetAuthorToBooksMap(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        Map<String, List<Book>> result = bookDatabase.getAuthorToBooksMap();
        result.entrySet().forEach(System.out::println);

    }

    @Override
    public String getActionName() {
        return "Get Author To Books Map";
    }
}
