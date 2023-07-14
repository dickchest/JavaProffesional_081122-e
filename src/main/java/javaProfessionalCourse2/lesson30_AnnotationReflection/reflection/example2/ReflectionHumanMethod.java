package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionHumanMethod {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Human john = new Human("John", "London");

        System.out.println(john);

        Method[] methods = Human.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equals("generateSecret")) {
                method.setAccessible(true);
                System.out.println("Method found");
                int secret = (int) method.invoke(john, "Our method is broken");
                System.out.println(secret);
            }
        }
    }
}
