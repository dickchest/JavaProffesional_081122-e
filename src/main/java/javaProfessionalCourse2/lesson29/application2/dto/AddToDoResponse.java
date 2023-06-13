package javaProfessionalCourse2.lesson29.application2.dto;

import javaProfessionalCourse2.lesson29.application2.core.validation.CoreError;

import java.util.List;

public class AddToDoResponse {
    private Integer createdToDoId;
    private List<CoreError> errors;
}
