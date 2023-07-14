package homework.extraHomeworkProfCourse.profBookApp.core.services;

import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreError;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.RemoveBookServiceValidator;
import homework.extraHomeworkProfCourse.profBookApp.dto.requests.RemoveBookRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.RemoveBookResponse;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RemoveBookService {
    BookDatabase bookDatabase;

    public RemoveBookResponse execute(RemoveBookRequest request) {
        RemoveBookServiceValidator validator = new RemoveBookServiceValidator();
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty() && errors != null) return new RemoveBookResponse(errors);
        else
        return new RemoveBookResponse(bookDatabase.delete(request.getId()));
    }
}
