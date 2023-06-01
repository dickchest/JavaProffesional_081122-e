package javaProfessionalCourse2.lesson26.synchExample2;

public class CommonApp {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CountThread(commonResource));
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
