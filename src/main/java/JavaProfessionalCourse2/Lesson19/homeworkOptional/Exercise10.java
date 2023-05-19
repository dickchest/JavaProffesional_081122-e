package JavaProfessionalCourse2.Lesson19.homeworkOptional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/*
10) Напишите метод, который получает список объектов и функцию проверки,
    и возвращает Optional с первым объектом в списке, который соответствует
    условиям функции проверки.
 */
public class Exercise10 {
    public static <T> Optional<T> findFirstMatchingObject(List<T> list, Predicate<T> condition) {
        return list
                .stream()
                .filter(condition)
                .findFirst();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        Optional<Integer> result = findFirstMatchingObject(list, n -> n%2 == 0);
        result.ifPresent(System.out::println);

        List<String> list1 = Arrays.asList("aaa","bbb","ccc");
        Optional<String> result1 = findFirstMatchingObject(list1, s -> s.startsWith("b") || s.startsWith("a"));
        result1.ifPresent(System.out::println);
    }
}
