package JavaProfessionalCourse2.Lesson20.String;

public class StringTimeTest {
    public static void main(String[] args) {
        String sb="";

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200_000; i++) {
            sb+=i;
        }
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
