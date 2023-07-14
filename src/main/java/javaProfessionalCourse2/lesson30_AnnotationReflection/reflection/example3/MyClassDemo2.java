package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example3;

import java.lang.reflect.InvocationTargetException;

/*
1. мы получаем полную ссылку на название класса
2. Класс лоадер должен загрузить этот класс в джава машину и создал на основании его переменную classForNew
3. хотим создать новый экземпляр класса и сохраним его в эту переменную
 */
public class MyClassDemo2 {
    public static void main(String[] args) {
//        MyClass myClass = null;


        String fullMyClassName = MyClass.class.getName();
        try {
            Class classForNewInstance = Class.forName(fullMyClassName); // загружаем класс в лоадер
            Class[] param = {int.class, String.class};
            MyClass myClass = (MyClass) classForNewInstance.getConstructor(param).newInstance(1, "default2");
            System.out.println(myClass);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
