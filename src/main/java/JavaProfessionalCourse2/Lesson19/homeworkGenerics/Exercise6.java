package JavaProfessionalCourse2.Lesson19.homeworkGenerics;

import java.util.ArrayList;
import java.util.List;

/*
6)  Напишите метод merge, который принимает два отсортированных списка и
    возвращает объединенный отсортированный список. Используйте Generics
    для обеспечения возможности передачи в метод списков любого типа.
 */
public class Exercise6 {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 5, 7);
        List<Integer> list2 = List.of(2, 4, 6, 8);

        List<Integer> mergeList = merge(list1, list2);
        System.out.println(mergeList);
    }

    public static <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            T element1 = list1.get(i);
            T element2 = list2.get(j);
            if (element1.compareTo(element2) <= 0) {
                mergedList.add(element1);
                i++;
            } else {
                mergedList.add(element2);
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

}
