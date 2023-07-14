package homework.extraHomeworkProfCourse.profBookApp.core.services;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.AddBookServiceValidator;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreError;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.RemoveBookServiceValidator;
import homework.extraHomeworkProfCourse.profBookApp.dto.requests.AddBookRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.AddBookResponse;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddBookServiceTest {
    private BookDatabaseImpl database;
    private AddBookService service;

    @BeforeEach
    public void before() {
        database = Mockito.mock(BookDatabaseImpl.class);
        service = new AddBookService(database);

        when(database.save(any(Book.class))).thenReturn(1L);
    }

    @Test
    public void checkAllOkAfterUserInput() {
        AddBookRequest request = new AddBookRequest("Title", "Author", "1234");

        AddBookResponse response = service.execute(request);
        Mockito.verify(database, times(1)).save(any(Book.class));

        Assertions.assertFalse(response.hasErrors());
        Assertions.assertEquals(null, response.getErrors());
        Assertions.assertEquals("Title", response.getBook().getTitle());
        Assertions.assertEquals("Author", response.getBook().getAuthor());
    }

    @Test
    public void checkNullUserRequest() {
        AddBookRequest request = new AddBookRequest(null, "", "1234");
        AddBookResponse response = service.execute(request);

        Mockito.verify(database, never()).save(any(Book.class));

        Assertions.assertFalse(response.getErrors().isEmpty());
    }
}