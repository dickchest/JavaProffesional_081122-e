package JavaProfessionalCourse2.Lesson19.homeworkOptional;

import java.util.List;
import java.util.Optional;

/*
3)  Напишите метод, который получает список целых чисел и
    возвращает сумму всех чисел в списке, используя Optional.
 */
public class Exercise3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers1 = null;
        Optional<Integer> sumOptional = getSum(numbers1);

        if (sumOptional.isPresent()) {
            System.out.println("Sum: " + sumOptional.get());
        } else {
            System.out.println("List is empty");

        }
    }

    public static Optional<Integer> getSum(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(numbers
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum()
        );
    }
}
