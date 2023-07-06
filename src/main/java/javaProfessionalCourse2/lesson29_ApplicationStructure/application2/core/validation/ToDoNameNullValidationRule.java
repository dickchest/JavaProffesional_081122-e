package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.validation;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.dto.AddToDoRequest;

public class ToDoNameNullValidationRule implements ValidationRule{
    @Override
    public void validate(AddToDoRequest request) {
        if(request.getName() == null) {
            throw new ValidationException("ToDo name must not be null");
        }
    }
}
