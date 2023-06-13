package javaProfessionalCourse2.lesson29.application2.dto;

import javaProfessionalCourse2.lesson20_Exceptions.String.StringTimeTest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // все геттеры и сеттеры хешкоды и тустринг
@AllArgsConstructor
public class AddToDoRequest {
    private String name;
    private String description;
}
