package JavaProfessionalCourse2.Lesson21.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JunitExercises {

    /*
    - метод getAverage() возвращает правильное среднее значение для
      списка чисел.
     */
    public static double getAvarage(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(val -> val.doubleValue())
                .average()
                .orElse(-1);
    }

    /*
        - метод getMax() возвращает правильное максимальное значение для
      списка чисел.
     */
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список элементов не может быть пустым");
        }
//        return list.stream()
//                .max(Comparator.comparing(Integer::intValue))
//                .orElse(null);
        return Collections.max(list);
    }
}
