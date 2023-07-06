package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.validation;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.dto.AddToDoRequest;

public interface ValidationRule {

    void validate(AddToDoRequest request);
}
