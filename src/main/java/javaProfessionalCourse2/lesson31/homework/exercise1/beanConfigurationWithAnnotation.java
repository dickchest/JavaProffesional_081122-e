package javaProfessionalCourse2.lesson31.homework.exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class beanConfigurationWithAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("homework/exercise1");

        Student student1 = (Student) context.getBean("getStudent");
        Student student2 = (Student) context.getBean("student");
        Student student3 = context.getBean("student", Student.class);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}
