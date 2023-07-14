package javaProfessionalCourse2.lesson30_AnnotationReflection.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnnotationExample {
    private int id;
    private String name;
    private String description;
}
