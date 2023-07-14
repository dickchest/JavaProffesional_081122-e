package homework.extraHomeworkProfCourse.profBookApp.core.services;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.dto.requests.GetAllBooksRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.GetAllBooksResponse;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GetAllBookServiceTest {
    private GetAllBookService service;
    @Mock
    private BookDatabaseImpl database;
    GetAllBooksResponse response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new GetAllBookService(database);
    }

    @Test
    public void testAllCollectionsOutputIfThereIsBooks() {
        List<Book> books = List.of(new Book("A1", "B1", "T1"), new Book("A2", "B2", "T2"));

        when(database.getBooks()).thenReturn(books);
        response = service.execute(new GetAllBooksRequest());

        verify(database).getBooks();

        Assertions.assertEquals(Collections.emptyList(), response.getErrors());
        Assertions.assertEquals(books, response.getBooks());
    }

    @Test
    public void testAllCollectionsNoBooks() {
        when(database.getBooks()).thenReturn(Collections.emptyList());
        response = service.execute(new GetAllBooksRequest());

        verify(database).getBooks();

        Assertions.assertEquals(Collections.emptyList(), response.getBooks());
    }

}