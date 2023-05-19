package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise10;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
10) Напишите метод sortByProperty, который принимает список объектов и
    имя поля, по которому нужно сортировать список. Используйте Generics
    для обеспечения возможности передачи в метод списка объектов любого
    типа и получения значения поля по имени.
 */
public class SortUtils {
    public static <T,R extends Comparable<R>> void sortByProperty(List<T> list, String propertyName) {

        Collections.sort(list, Comparator.comparing(obj -> {
            try {
                Field fields = obj.getClass().getDeclaredField(propertyName);
                fields.setAccessible(true);
//                System.out.println(fields.get(obj));
                return (R) fields.get(obj);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }));
//        Collections.sort(list, new Comparator<T>() {
//            @Override
//            public int compare(T obj1, T obj2) {
//                try {
//                    Field field = obj1.getClass().getField(propertyName);
//                    field.setAccessible(true);
//                    R value1 = (R) field.get(obj1);
//                    R value2 = (R) field.get(obj2);
//                    return value1.compareTo(value2);
//                } catch (NoSuchFieldException | IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
    }
}
