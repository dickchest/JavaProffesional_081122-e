package homework.extraHomeworkProfCourse.bookLibraryApp.search;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;

public class TitleSearchCriteria implements SearchCriteria{
    private String titleToSearch;

    public TitleSearchCriteria(String titleToSearch) {
        this.titleToSearch = titleToSearch;
    }

    @Override
    public boolean match(Book book) {
        // допишите реализацию метода
        // return true - если автор книги совпадает с this.titleToSearch
        // иначе return false
        return book.getTitle().equals(this.titleToSearch);
    }
}
