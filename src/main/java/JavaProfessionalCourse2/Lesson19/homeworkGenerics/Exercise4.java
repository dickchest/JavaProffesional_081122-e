package JavaProfessionalCourse2.Lesson19.homeworkGenerics;
/*
4)  Напишите метод findMax, который принимает массив объектов и возвращает
    наибольший из них. Используйте Generics для обеспечения возможности
    передачи массива объектов любого типа.
 */
import java.util.Arrays;

public class Exercise4{
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};
        System.out.println(findMax(array));

        Double[] array1 = {1.01,2.01,2.00001,2.00};
        System.out.println(findMax(array1));

        Integer[] array2 = {};
        System.out.println(findMax(array2));

        String[] array3 = {"11","2","3","4"};
        System.out.println(findMax(array3));
    }

    public static <T extends Comparable<T>> T findMax(T[] array) {

        return Arrays.stream(array)
                .max(Comparable::compareTo)
                .orElse(null);
    }
}
