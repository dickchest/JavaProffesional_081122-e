package javaProfessionalCourse2.lesson23_multitreading.multithredading;

public class MySecondThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MySecondThread thread = new MySecondThread();
            thread.start();
        }
    }
}
