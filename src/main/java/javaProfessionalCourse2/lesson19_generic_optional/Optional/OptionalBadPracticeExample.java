package javaProfessionalCourse2.lesson19_generic_optional.Optional;

import java.io.Serializable;
import java.util.Optional;

public class OptionalBadPracticeExample implements Serializable {
    Optional<String> optString;

    public void method1(Optional<String> optString) {
        System.out.println("1234");
    }

    public static void main(String[] args) {
        System.out.println("1234");
    }

}
