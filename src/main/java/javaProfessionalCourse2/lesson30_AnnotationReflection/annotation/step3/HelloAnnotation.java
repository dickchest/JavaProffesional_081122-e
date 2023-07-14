package javaProfessionalCourse2.lesson30_AnnotationReflection.annotation.step3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HelloAnnotation {
    String value();
    String greetTo();
}
