package javaProfessionalCourse2.lesson23_multitreading.multithredading;

public class MyFirstThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyFirstThread thread = new MyFirstThread();
            thread.start();
        }
    }
}
