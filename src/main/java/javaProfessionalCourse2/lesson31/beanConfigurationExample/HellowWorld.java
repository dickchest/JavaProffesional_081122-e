package javaProfessionalCourse2.lesson31.beanConfigurationExample;

public class HellowWorld {

    private String message;

    public HellowWorld(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;


    }
}
