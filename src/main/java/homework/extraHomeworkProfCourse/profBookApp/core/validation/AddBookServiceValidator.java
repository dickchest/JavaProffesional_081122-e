package homework.extraHomeworkProfCourse.profBookApp.core.validation;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.AddBookRequest;

import java.util.ArrayList;
import java.util.List;
/*
Вынести логику валидации входных данных из класса AddBookService
в отдельный класс AddBookServiceValidator с методом:
    public List<CoreError> validate(AddBookRequest request)
 */

public class AddBookServiceValidator {
    public List<CoreError> validate(AddBookRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateFieldNotNull(request.getTitle(), errors, "title");
        validateFieldNotNull(request.getAuthor(), errors, "author");

        return errors;
    }

    private static void validateFieldNotNull(String request, List<CoreError> errors, String title) {
        if (request == null || request.isEmpty() || request.isBlank()) {
            errors.add(new CoreError(title, "Field can not be empty!"));
        }
    }
}
