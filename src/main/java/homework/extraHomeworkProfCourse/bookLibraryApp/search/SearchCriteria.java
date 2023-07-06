package homework.extraHomeworkProfCourse.bookLibraryApp.search;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;

public interface SearchCriteria {
    boolean match(Book book);
}
