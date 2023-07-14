package homework.extraHomeworkProfCourse.profBookApp.search;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;

public interface SearchCriteria {
    boolean match(Book book);
}
