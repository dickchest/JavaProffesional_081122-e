package homework.extraHomeworkProfCourse.profBookApp.core.validation;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.RemoveBookRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
Реализуйте валидацию входных данных для DeleteBookRequest.
Id удаляемого объекта это обязательное поле, если оно не
заполнено то бизнес логика должна возвращать ошибку.
 */
public class RemoveBookServiceValidator {

    public List<CoreError> validate(RemoveBookRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateID(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateID(RemoveBookRequest request) {
        return (request.getId() != null && request.getId() <= 0L)
                ? Optional.of(new CoreError("id", "Field can not be empty!"))
                : Optional.empty();
    }
}
