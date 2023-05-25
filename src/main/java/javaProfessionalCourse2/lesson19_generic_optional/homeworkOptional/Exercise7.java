package javaProfessionalCourse2.lesson19_generic_optional.homeworkOptional;

import java.util.Optional;

/*
7)  Напишите метод, который получает значение типа Double и возвращает
    его квадратный корень, если оно не равно null и положительное, или
    бросит исключение IllegalArgumentException в противном случае,
    используя Optional.
 */
public class Exercise7 {
    public static Double getSqrt(Double value) {
        return Optional.ofNullable(value)
                .filter(v -> v > 0 )
                .map(Math::sqrt)
                .orElseThrow(() -> new IllegalArgumentException("null or less then 0"));
    }

    public static void main(String[] args) {
        System.out.println(getSqrt(8.0));
        System.out.println(getSqrt(-8.0));
    }
}
