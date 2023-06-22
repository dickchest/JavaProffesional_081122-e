package javaProfessionalCourse2.lesson31.homework.exercise1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJavaConfig {

    @Bean
    public Student getStudent() {
        return new Student();
    }

    @Bean("student")
    public Student getFullStudent() {
        return new Student("vasya", 25);
    }

}
