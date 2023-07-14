package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionDemo4 {
    public static void main(String[] args) {

        MyReflectionClassConstructor myClass = null;
        try {
            Class clazz = Class.forName(MyReflectionClassConstructor.class.getName());
            Class[] params = {int.class, String.class};
            myClass = (MyReflectionClassConstructor) clazz.getConstructor(params).newInstance(1, "default2");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output created object reflection.MyClass@60e53b93

        //--------- продолжение --------

        try {
            Class clazz = Class.forName(MyReflectionClassConstructor.class.getName());

            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
