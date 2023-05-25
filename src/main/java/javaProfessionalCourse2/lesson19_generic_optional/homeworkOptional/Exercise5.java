package javaProfessionalCourse2.lesson19_generic_optional.homeworkOptional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/*
5)  Напишите метод, который получает список строк и возвращает
    первую строку в списке, если она существует, или бросает
    исключение NoSuchElementException, используя Optional.
 */
public class Exercise5 {
    public static String getFirstRow(List<String> list) {
        java.util.Optional<String> firstString = list
                .stream()
                .findFirst();
        return firstString.orElseThrow(NoSuchElementException::new);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World");
        List<String> strings1 = Arrays.asList();

        try {
            String firstString = getFirstRow(strings1);
            System.out.println(firstString);
        } catch (NoSuchElementException e) {
            System.out.println("List is empty");
        }
    }
}
