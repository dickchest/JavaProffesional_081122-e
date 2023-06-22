package javaProfessionalCourse2.lesson31.beanConfigurationExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansV1.xml");

        HellowWorld objA = (HellowWorld) context.getBean("helloWorld");

        objA.setMessage("I'm object A");
        objA.getMessage();


        HellowWorld objB = (HellowWorld) context.getBean("helloWorld");
        objB.getMessage();
    }
}
