package JavaProfessionalCourse2.Lesson20.Exceptions;

import java.util.ArrayList;
import java.util.Arrays;

public class OutOfMemoryExample {
    public static void main(String[] args) {
        OutOfMemoryExample no = new OutOfMemoryExample();
        ArrayList<String> newList = new ArrayList<>();
        int count = 0;

        while (true) {
            newList.add(Arrays.toString(no.newStringArray()));
            count++;

        }
    }

    String[] newStringArray() {
        String[] newArray = new String[1_000_000];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = "lsdkjfkladsjflkadsjflkjasdf";
        }
        return newArray;
    }
}
