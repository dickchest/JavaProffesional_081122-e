package javaProfessionalCourse2.lesson31;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class temp {
    public static void main(String[] args) {
        Predicate<String> pred ="Java"::equals;
        System.out.println(pred.test("Java"));
        System.out.println(pred.test("Kotlin"));

        Consumer<Object> lambdaPrinter = obj -> System.out.println(obj);
        Consumer<Object> methodPrinter = System.out::println;

        methodPrinter.accept("1234" );

        double[] randomArray = DoubleStream.generate(Math::random)
                .limit(100)
                .toArray();

        System.out.println(Arrays.toString(randomArray));

        int[] rArr = IntStream.generate(() -> new Random().nextInt(100))
                .limit(100)
                .toArray();
        System.out.println(Arrays.toString(rArr));


    }
}
