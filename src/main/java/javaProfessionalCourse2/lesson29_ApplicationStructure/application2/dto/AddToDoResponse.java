package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.dto;

import javaProfessionalCourse2.lesson29_ApplicationStructure.application2.core.validation.CoreError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AddToDoResponse {
    private Integer createdToDoId;
    private List<CoreError> errors;
}
