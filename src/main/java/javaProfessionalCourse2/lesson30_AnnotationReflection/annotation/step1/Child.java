package javaProfessionalCourse2.lesson30_AnnotationReflection.annotation.step1;

public class Child extends Parent{
    @Override
    @Deprecated(since = "1.2", forRemoval = true)
    public void display() {
        System.out.println("Выполняется метод из класса наследника");
    }
}
