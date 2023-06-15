package javaProfessionalCourse2.lesson29.application2.core.validation;

import javaProfessionalCourse2.lesson29.application2.dto.AddToDoRequest;

public class ToDoDescriptionNullValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("ToDo description must not be null");
        }
    }
}