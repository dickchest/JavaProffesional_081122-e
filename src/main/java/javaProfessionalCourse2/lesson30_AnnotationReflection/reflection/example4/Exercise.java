package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exercise {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Sample obj = new Sample();

        // создаем новый объект Класс из нашего объекта obj
        Class cls = obj.getClass();
        System.out.println("Имя класса: " + cls.getName());

        // получаем имя конструктор
        Constructor constructor = cls.getConstructor();
        System.out.println("Имя конструктора: " + constructor.getName());

        // получаем публичные методы класса
        System.out.println("Публичные методы класса:");
        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //создадим объект нужного метода и параметра класса
        Method methodcall2 = cls.getDeclaredMethod("method2", int.class);
        methodcall2.invoke(obj, 25);


        // создать объект нужного поля с помощью имени поля

        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);
        field.set(obj, "Group BE01-081122-e");
        Method methodcall1 = cls.getDeclaredMethod("method1");
        methodcall1.invoke(obj);

        // создадим третий объект метода

        Method methodcall3 = cls.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);

    }
}
