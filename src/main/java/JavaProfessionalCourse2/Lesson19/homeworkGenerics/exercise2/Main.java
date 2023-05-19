package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise2;

import java.util.Arrays;
import java.util.List;

/*
2)  Напишите метод printList, который принимает список объектов и
    выводит их на экран. Используйте Generics для обеспечения
    типобезопасности и возможности передачи списка объектов любого типа.
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = List.of("Red", "Green", "Blue");
        printList(list);

        List<Integer> list1 = List.of(1, 2, 3);
        printList(list1);

        List<Boolean> list2 = Arrays.asList(true, true, false);
        printList(list2);
    }

    public static <T> void printList(List<T> list) {
        System.out.println(list.toString());
    }
}
