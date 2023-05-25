package javaProfessionalCourse2.lesson20_Exceptions.String;

import java.util.Arrays;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        sb.append(new Integer(2));
        sb.append(";");
        sb.append(true);
        sb.append(Arrays.asList(1,2,3));

        sb.deleteCharAt(0);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200_000; i++) {
            sb.append(i);
        }
        System.out.println(System.currentTimeMillis()-startTime);

    }
}
