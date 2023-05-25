package javaProfessionalCourse2.lesson19_generic_optional.homeworkOptional;

import java.util.Optional;

/*
2)  Напишите метод, который получает значение типа Integer и
    возвращает его удвоенное значение, если оно не равно null,
    используя Optional.
 */
public class Exercise2 {
    public static void main(String[] args) {
//        System.out.println(doubleInteger(null));
        System.out.println(getDoubleValue(null));
        System.out.println(doubleInteger(5));
        System.out.println(getDoubleValue(5));
    }

    public static int doubleInteger(Integer number) {
        return Optional.ofNullable(number * 2)
                .orElse(0);
    }

    public static int getDoubleValue(Integer value) {
        return Optional.ofNullable(value)
                .map(v -> v * 2)
                .orElse(0);
    }

    /*
    Таким образом, основная разница между двумя методами заключается в том, что doubleInteger пытается удвоить значение,
    даже если оно может быть null, в то время как getDoubleValue удваивает значение только в случае, если оно не null.
     */
}
