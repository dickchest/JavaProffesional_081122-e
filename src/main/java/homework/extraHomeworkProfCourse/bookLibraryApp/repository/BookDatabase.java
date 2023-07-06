package homework.extraHomeworkProfCourse.bookLibraryApp.repository;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;
import homework.extraHomeworkProfCourse.bookLibraryApp.search.SearchCriteria;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookDatabase{
    void print();
    Long save(Book book);
    boolean delete(Long bookId);
    boolean delete(Book book);
    Optional<Book> findById(Long bookId);
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    int countAllBooks();
    void deleteByAuthor(String author);
    void deleteByTitle(String title);

    List<Book> find(SearchCriteria searchCriteria);
    boolean contains(Book book);
    Map<String, List<Book>> getAuthorToBooksMap();
    Map<String, Integer> getEachAuthorBookCount();

}
