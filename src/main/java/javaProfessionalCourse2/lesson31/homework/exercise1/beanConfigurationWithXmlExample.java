package javaProfessionalCourse2.lesson31.homework.exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanConfigurationWithXmlExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factory-demo.xml");

        Student student1 = (Student) context.getBean("student");

        System.out.println(student1.getName());
        System.out.println(student1.getAge());

        student1.setName("Peter");
        student1.setAge(21);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());


    }
}
