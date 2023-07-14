package javaProfessionalCourse2.lesson30_AnnotationReflection.annotation.step3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@HelloAnnotation(value = "Hello", greetTo = "Universe")
public class GettingAnnotation {
    public static void main(String[] args) {
        GettingAnnotation demo = new GettingAnnotation();

        Class<? extends GettingAnnotation> clazz = demo.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        for (Annotation annotation : annotations) {
            System.out.println("Annotation Type: " + annotation.annotationType());
        }

        HelloAnnotation annotation = clazz.getAnnotation(HelloAnnotation.class);
        System.out.println("Value   : " + annotation.value());
        System.out.println("GreedTo : " + annotation.greetTo());

        try {
            Method m = clazz.getMethod("sayHi");

            annotation = m.getAnnotation(HelloAnnotation.class);
            System.out.println("Value   : " + annotation.value());
            System.out.println("GreedTo : " + annotation.greetTo());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        demo.sayHello();
    }

    @HelloAnnotation(value = "Hi", greetTo = "Alice")
    public void sayHi() {
    }

    @HelloAnnotation(value = "Hello", greetTo = "Bob")
    public void sayHello() {
        try {
            Method method = getClass().getMethod("sayHello");
            HelloAnnotation annotation = method.getAnnotation(HelloAnnotation.class);

            System.out.println(annotation.value() + " " + annotation.greetTo());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
