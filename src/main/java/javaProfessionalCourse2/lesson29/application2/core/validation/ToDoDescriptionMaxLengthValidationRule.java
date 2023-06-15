package javaProfessionalCourse2.lesson29.application2.core.validation;

import javaProfessionalCourse2.lesson29.application2.dto.AddToDoRequest;

public class ToDoDescriptionMaxLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName().length() > 20) {
            throw new ValidationException("ToDo description length mus be " +
                    "less then 20 but actual name length is " +
                    request.getName().length());
        }
    }
}
