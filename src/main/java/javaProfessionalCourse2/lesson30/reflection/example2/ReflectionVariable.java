package javaProfessionalCourse2.lesson30.reflection.example2;

import java.lang.reflect.Field;

public class ReflectionVariable {
    public static void main(String[] args) throws IllegalAccessException {
        Human john = new Human("John", "London");

        System.out.println(john);

        Field[] fields = Human.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals("name")) {
                System.out.println("Field found");
                field.setAccessible(true);
                field.set(john, "Bill");
            }
        }

        System.out.println(john);

    }
}
