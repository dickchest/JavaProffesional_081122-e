package homework.extraHomeworkProfCourse.bookLibraryApp.repository;

import homework.extraHomeworkProfCourse.bookLibraryApp.core.Book;
import homework.extraHomeworkProfCourse.bookLibraryApp.search.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookDatabaseImpl implements BookDatabase{
    private List<Book> books;
    private Long currentId;

    public BookDatabaseImpl() {
        books = new ArrayList<>();
        currentId = 0L;
    }

    public void print() {
        System.out.println(books);
    }

    @Override
    public Long save(Book book) {
        if (!this.contains(book)) {
            currentId++;
            book.setId(currentId);
            books.add(book);
            return currentId;
        }
        return -1L;
    }

    @Override
    public boolean delete(Long bookId) {
        if (bookId == null || bookId < 1 || bookId > currentId) {
            System.out.println("Error! Incorrect book ID");
            return false;
        }

        for (Book book : books) {
            if (book.getId() == bookId) {
                return books.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return books.remove(book);
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        for (Book book : books) {
            if (book.getId()==bookId) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        return books.stream()
                .filter(x -> x.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> booksByAuthor = new ArrayList<>();
        return books.stream()
                .filter(x -> x.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public int countAllBooks() {
        return books.size();
    }

    @Override
    public void deleteByAuthor(String author) {
        books.removeAll(this.findByAuthor(author));
    }

    @Override
    public void deleteByTitle(String title) {
        books.removeAll(this.findByTitle(title));
    }

    @Override
    public List<Book> find(SearchCriteria searchCriteria) {
        return books.stream()
                .filter(x -> searchCriteria.match(x))
                .collect(Collectors.toList());
    }

    @Override
    public boolean contains(Book book) {
        return books.contains(book);
    }

    @Override
    public Map<String, List<Book>> getAuthorToBooksMap() {
        /*
        Данный метод должен возвращать мап в котором ключём является
        автор, а значением список книг этого автора.
         */
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, Integer> getEachAuthorBookCount() {
        return books.stream()
                .collect(Collectors.toMap(Book::getAuthor, book -> 1, Integer::sum));
    }
}
