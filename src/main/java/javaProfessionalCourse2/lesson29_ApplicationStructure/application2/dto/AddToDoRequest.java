package javaProfessionalCourse2.lesson29_ApplicationStructure.application2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // все геттеры и сеттеры хешкоды и тустринг
@NoArgsConstructor
public class AddToDoRequest {
    private String name;
    private String description;
}
