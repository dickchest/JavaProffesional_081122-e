package javaProfessionalCourse2.lesson31.weekDay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class WeekDayApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(WeekDayConfig.class);

        WeekDay weekDay = context.getBean(WeekDay.class);

        System.out.println("It is " + weekDay.getWeekDayName() + " todoay!");


    }
}
