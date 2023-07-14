package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example2;

public class ReflectionHuman {
    public static void main(String[] args) {
        Human john = new Human("John", "London");

        Class humanClass = john.getClass();

        System.out.println(humanClass);
    }
}
