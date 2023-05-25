package javaProfessionalCourse2.lesson19_generic_optional.homeworkGenerics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
8)  Напишите метод filter, который принимает список объектов и предикат,
    и возвращает список объектов, удовлетворяющих предикату. Используйте
    Generics для обеспечения возможности передачи в метод списка объектов
    любого типа.
 */
public class Exercise8 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Predicate<Integer> predicate = number -> number % 2 == 0;
        List<Integer> filteredList = filter(list, predicate);

        System.out.println(filteredList);

        // -----

        List<String> list1 = List.of("Alice", "Bob", "Charlie", "Dave", "Eve");
        Predicate<String> predicate1 = str -> str.length() > 3;
        List<String> filteredList1 = filter(list1, predicate1);

        System.out.println(filteredList1);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();

        for (T element : list) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }
}
