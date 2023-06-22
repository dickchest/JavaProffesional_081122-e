package javaProfessionalCourse2.lesson31.annotationConfiguration;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String name = "Barsik";

    public Cat() {
        System.out.println("Cat constuctor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
