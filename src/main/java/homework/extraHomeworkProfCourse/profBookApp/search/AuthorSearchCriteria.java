package homework.extraHomeworkProfCourse.profBookApp.search;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;

public class AuthorSearchCriteria implements SearchCriteria {
    private String authorToSearch;

    public AuthorSearchCriteria(String authorToSearch) {
        this.authorToSearch = authorToSearch;
    }

    @Override
    public boolean match(Book book) {
        // допишите реализацию метода
        // return true - если автор книги совпадает с this.authorToSearch
        // иначе return false
        return book.getAuthor().equals(this.authorToSearch);
    }
}
