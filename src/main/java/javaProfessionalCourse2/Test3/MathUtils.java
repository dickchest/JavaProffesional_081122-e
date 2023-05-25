package javaProfessionalCourse2.Test3;

import java.util.function.IntFunction;

/*
Создайте класс со статическими методами, реализующими следующие математические функции: y = x*x, y = 3x+5, y = 1/x, y = x*x*x, y = |x|.
В основной программе создайте метод test(), который будет принимать  в качестве аргумента ссылку на один из методов, реализующих математическую функцию,
и выводить в консоль результат вычисления функции для целых чисел x в интервале -10 < x < -1.
 */
public class MathUtils {
    public static int square(int x) {
        return x * x;
    }

    public static int linear(int x) {
        return 3 * x + 5;
    }

    public static double inverseProportionality(int x) {
        return 1 / x;
    }

    public static int cubic(int x) {
        return x * x * x;
    }

    public static int absolute(int x) {
        return Math.abs(x);
    }

    public static void test(IntFunction<?> function) {
        for (int i = -10; i <= -1; i++) {
            Object result = function.apply(i);
            System.out.println("x = " + i + ", y = " + result);
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing square function");
        test(MathUtils::square);

        System.out.println("Testing linear function");
        test(MathUtils::linear);

        System.out.println("Testing inverseProportionality function");
        test(MathUtils::inverseProportionality);

        System.out.println("Testing cubic function:");
        test(MathUtils::cubic);

        System.out.println("Testing absolute function:");
        test(MathUtils::absolute);
    }
}
