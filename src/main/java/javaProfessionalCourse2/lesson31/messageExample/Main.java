package javaProfessionalCourse2.lesson31.messageExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

//        Message message = (Message) context.getBean("printMessage");
        Message message = context.getBean(Message.class);

        message.setMessage("This is simple message");

        System.out.println(message);
    }
}
