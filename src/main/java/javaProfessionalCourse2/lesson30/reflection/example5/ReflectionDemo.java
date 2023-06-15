package javaProfessionalCourse2.lesson30.reflection.example5;

import java.lang.reflect.Field;

public class ReflectionDemo {
    public static void main(String[] args) {
        MyReflectionClass myReflectionClass = new MyReflectionClass();
        int number = myReflectionClass.getNumber();
        String name = null; //no getter =(
        System.out.println(number + " " + name);//output 0 null


        //------ продолжение -------

        try {
            Field field = myReflectionClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(myReflectionClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(number + " " + name);//output 0 default
    }

}
