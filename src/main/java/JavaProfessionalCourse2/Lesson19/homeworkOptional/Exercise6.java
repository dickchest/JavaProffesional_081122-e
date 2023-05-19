package JavaProfessionalCourse2.Lesson19.homeworkOptional;

import java.util.Optional;

/*
6)  Напишите метод, который получает значение типа Integer и
    возвращает его удвоенное значение, если оно не равно null,
    или бросает исключение IllegalArgumentException, используя Optional.
 */
public class Exercise6 {
    public static Integer getDoubleValue(Integer value) {
        return Optional.ofNullable(value)
                .map(v -> v * 2)
                .orElseThrow(() -> new IllegalArgumentException("Value is null")
                );
    }

    public static void main(String[] args) {
        try {
            int x = 5;
            Integer y = null;
            System.out.println(getDoubleValue(x));
            System.out.println(getDoubleValue(y));
        } catch (IllegalArgumentException e) {
            System.out.println("Value is null");
        }
    }
}
