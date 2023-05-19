package JavaProfessionalCourse2.Lesson19.homeworkOptional;

import java.util.Optional;

/*
4)  Напишите метод, который получает значение типа String и
    возвращает его длину, если оно не равно null, используя Optional.
 */
public class Exercise4 {
    public static Optional<Integer> getLength(String str) {
        return Optional.ofNullable(str)
                .map(String::length);
    }

    public static void main(String[] args) {
        String str = "Hello World";
        String str1 = null;
        System.out.println(getLength(str).get());
        System.out.println(getLength(str1));

    }
}
