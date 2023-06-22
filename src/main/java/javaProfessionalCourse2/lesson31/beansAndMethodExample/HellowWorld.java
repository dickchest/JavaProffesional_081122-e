package javaProfessionalCourse2.lesson31.beansAndMethodExample;

public class HellowWorld {

    public void init() throws Exception {
        System.out.println("я инит-метод " + this.getClass().getSimpleName());
    }

    public void destroy() throws Exception {
        System.out.println("я дестрой-метод " + this.getClass().getSimpleName());
    }
}
