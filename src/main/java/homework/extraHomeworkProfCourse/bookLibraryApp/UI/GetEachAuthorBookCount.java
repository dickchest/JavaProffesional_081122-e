package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;
import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;

import java.util.List;
import java.util.Map;

public class GetEachAuthorBookCount implements UIAction{
    private BookDatabase bookDatabase;

    public GetEachAuthorBookCount(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        Map<String, Integer> result = bookDatabase.getEachAuthorBookCount();
        result.entrySet().forEach(System.out::println);

    }

    @Override
    public String getActionName() {
        return "Get Each Author Book Count";
    }
}
