package javaProfessionalCourse2.lesson19_generic_optional.homeworkOptional;

import java.util.Optional;

/*
1)  Напишите метод, который получает список строк и возвращает
    первую строку в списке, если она существует,
    или пустую строку в противном случае, используя Optional.
 */
public class Exercise1 {
    public static void main(String[] args) {
        String multiLine = "Line 1 \nLine 2\n Line3";

        System.out.println(getFirstString(null));
        System.out.println(getFirstString(multiLine));


    }

    public static String getFirstString(String string) {
        return Optional.ofNullable(string)
                .map(s -> s.split("\n")[0].trim())
                .orElse("");
    }
}
