package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoDTO {
    private String name;
    private String description;
}
