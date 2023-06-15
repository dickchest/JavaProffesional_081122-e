package javaProfessionalCourse2.lesson30.reflection.example5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo2 {
    public static void main(String[] args) {

        MyReflectionClass myClass = new MyReflectionClass();
        int number = myClass.getNumber();
        String name = null; //?
        printData(myClass); // outout 0default
        try {
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(myClass, (String) "new value");
            name = (String) field.get(myClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        printData(myClass);// output 0new value
    }


    //  --------- продолжение 2 ------

    public static void printData(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
