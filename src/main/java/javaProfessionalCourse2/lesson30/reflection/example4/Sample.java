package javaProfessionalCourse2.lesson30.reflection.example4;

public class Sample {
    private String s;

    public Sample() {
        s = "Java Reflection API";
    }

    public void method1() {
        System.out.println(" Информация в строке - " + s);
    }

    public void method2(int x) {
        System.out.println("Целое число - " + x);
    }

    private void method3() {
        System.out.println("Вызов приватного метода");
    }
}
