package javaProfessionalCourse2.lesson29.application2.dto;

import javaProfessionalCourse2.lesson29.application2.core.validation.CoreError;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindAllToDoResponse {
    private List<ToDoDTO> todos;
    private List<CoreError> errors;

}
