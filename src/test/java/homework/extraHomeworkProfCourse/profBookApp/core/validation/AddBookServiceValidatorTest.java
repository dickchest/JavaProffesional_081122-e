package homework.extraHomeworkProfCourse.profBookApp.core.validation;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.AddBookRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AddBookServiceValidatorTest {
    // Arrange global
    AddBookServiceValidator validator = new AddBookServiceValidator();
    String message = "Field can not be empty!";

    @Test
    public void validateNullTitle() {
        // Arrange
        AddBookRequest request = new AddBookRequest("", "author", "0");

        // Act
        List<CoreError> errorsReceived = validator.validate(request);

        // Assert
        Assert.assertEquals(1, errorsReceived.size());
        CoreError error = errorsReceived.get(0);
        Assert.assertEquals("title", errorsReceived.get(0).getField());
        Assert.assertEquals(message, errorsReceived.get(0).getMessage());
    }

    @Test
    public void validateNullAuthor() {
        // Arrange
        AddBookRequest request = new AddBookRequest("1234", "", "");

        // Act
        List<CoreError> errorsReceived = validator.validate(request);

        // Assert
        Assert.assertEquals(1, errorsReceived.size());
        CoreError error = errorsReceived.get(0);
        Assert.assertEquals("author", errorsReceived.get(0).getField());
        Assert.assertEquals(message, errorsReceived.get(0).getMessage());
    }

    @Test
    public void validateNullTitleAndAuthor() {
        // Arrange
        AddBookRequest request = new AddBookRequest("", "", "");

        // Act
        List<CoreError> errorsReceived = validator.validate(request);

        // Assert
        Assertions.assertEquals(2, errorsReceived.size());
        CoreError error1 = errorsReceived.get(0);
        Assert.assertEquals("title", error1.getField());
        Assert.assertEquals(message, error1.getMessage());
        CoreError error2 = errorsReceived.get(1);
        Assert.assertEquals("author", error2.getField());
        Assert.assertEquals(message, error2.getMessage());
    }

    @Test
    public void validateNotNullTitleAndAuthor_ReturnNoErrors() {
        // Arrange
        AddBookRequest request = new AddBookRequest("123", "1234", "1234");

        // Act
        List<CoreError> errorsReceived = validator.validate(request);

        // Assert
        Assertions.assertTrue(errorsReceived.isEmpty());
    }
}