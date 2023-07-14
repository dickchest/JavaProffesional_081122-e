package javaProfessionalCourse2.lesson30_AnnotationReflection.reflection.example5;

public class ReflectionDemo3 {
    public static void main(String[] args) {

        MyReflectionClass myClass = null;
        try {
            Class clazz = Class.forName(MyReflectionClass.class.getName());
            myClass = (MyReflectionClass) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output created object lessons.lesson35.reflection.example2.MyReflectionClass@7ef20235


    }


}
