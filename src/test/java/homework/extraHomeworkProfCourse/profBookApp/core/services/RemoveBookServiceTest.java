package homework.extraHomeworkProfCourse.profBookApp.core.services;

import homework.extraHomeworkProfCourse.profBookApp.core.validation.RemoveBookServiceValidator;
import homework.extraHomeworkProfCourse.profBookApp.dto.requests.RemoveBookRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.RemoveBookResponse;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RemoveBookServiceTest {
    @Mock
    private BookDatabaseImpl database;
    private RemoveBookService removeBookService;
    private RemoveBookServiceValidator validator;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        removeBookService = new RemoveBookService(database);
        validator = new RemoveBookServiceValidator();
    }

    @Test
    public void testExecuteCorrectly() {
        RemoveBookRequest request = new RemoveBookRequest(1L);
        when(database.delete(request.getId())).thenReturn(true);

        RemoveBookResponse response = removeBookService.execute(request);

        verify(database).delete(request.getId());

        Assertions.assertTrue(response.isDeleted());
        Assertions.assertFalse(response.hasErrors());
        Assertions.assertEquals(Collections.emptyList(), response.getErrors());
    }

    @Test
    public void testExecuteNullRequest() {
        RemoveBookRequest request = new RemoveBookRequest(null);
        when(database.delete(request.getId())).thenReturn(false);

        RemoveBookResponse response = removeBookService.execute(request);

        verify(database).delete(request.getId());

        Assertions.assertFalse(response.isDeleted());
        Assertions.assertTrue(response.hasErrors());
        Assertions.assertEquals(1, response.getErrors().size());
    }

}