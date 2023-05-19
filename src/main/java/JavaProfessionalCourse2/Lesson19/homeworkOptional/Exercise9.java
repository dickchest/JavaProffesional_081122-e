package JavaProfessionalCourse2.Lesson19.homeworkOptional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/*
9)  Напишите метод, который получает HashSet и функцию преобразования,
    и возвращает HashSet, в котором все значения преобразованы с помощью
    функции преобразования, если HashSet не пустой. Если HashSet пустой,
    метод возвращает пустой HashSet.
 */
public class Exercise9 {
    public static <T, R> Optional<Set<R>> transformHashSet(HashSet<T> set, Function<T, R> transformer) {
        Set<R> transformedSet = new HashSet<>();
        if (!set.isEmpty()) {
            for (T element : set) {
                transformedSet.add(transformer.apply(element));
            }
        } else {
            return Optional.empty();
        }
        return Optional.of(transformedSet);
    }

    public static void main(String[] args) {
        HashSet<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);

        Optional<Set<String>> transformedSet = transformHashSet(integerSet, String::valueOf);
        System.out.println(transformedSet);

        HashSet<String> stringSet = new HashSet<>();
        Optional<Set<String>> transformedEmptySet = transformHashSet(stringSet, val -> val.toUpperCase());
        System.out.println(transformedEmptySet);
    }

}
