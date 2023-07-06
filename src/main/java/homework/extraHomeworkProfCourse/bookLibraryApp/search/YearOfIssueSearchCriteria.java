package homework.extraHomeworkProfCourse.bookLibraryApp.search;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;

public class YearOfIssueSearchCriteria implements SearchCriteria{
    private String yearOfIssueToSearch;

    public YearOfIssueSearchCriteria(String yearOfIssueToSearch) {
        this.yearOfIssueToSearch = yearOfIssueToSearch;
    }

    @Override
    public boolean match(Book book) {
        return book.getYearOfIssue().equals(yearOfIssueToSearch);
    }
}
