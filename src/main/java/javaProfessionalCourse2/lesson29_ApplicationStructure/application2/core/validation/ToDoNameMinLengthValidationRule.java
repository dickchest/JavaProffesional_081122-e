package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.validation;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.dto.AddToDoRequest;

public class ToDoNameMinLengthValidationRule implements ValidationRule {
    @Override
    public void validate(AddToDoRequest request) {
        if (request.getName().length() < 3) {
            throw new ValidationException("ToDo name length mus be " +
                    "greater that 3 but actual name length is " +
                    request.getName().length());
        }
    }
}
