package javaProfessionalCourse2.lesson21_test_junit_mochito.homework;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static javaProfessionalCourse2.lesson21_test_junit_mochito.homework.JunitExercises.getAvarage;
import static javaProfessionalCourse2.lesson21_test_junit_mochito.homework.JunitExercises.getMax;
import static org.junit.Assert.assertEquals;

class ExercisesTest {
    /*
        Напишите тест, который проверяет, что:
    - метод toUpperCase() возвращает верное значение для строки "hello"
      (ожидаемый результат - "HELLO").
     */
    @Test
    public void testToUpeerCase() {
        String input = "hello";
        String expectedOutput = "HELLO";

        String result = input.toUpperCase();

        Assert.assertEquals(expectedOutput, result);
    }

    /*
    - метод contains() возвращает true для строки "hello world", когда
      мы ищем подстроку "world".
     */
    @Test
    public void testContains() {
        String input = "hello world";
        boolean expected = true;

        boolean result = input.contains("world");
        assertEquals(expected, result);
    }

    /*
        - метод substring() правильно обрезает строку. Например, когда мы
      вызываем substring(2, 4) для строки "hello", мы ожидаем получить "ll".
     */
    @Test
    void testSubstring() {
        assertEquals("ll", "hello".substring(2, 4));
    }

    /*
        - метод getAverage() возвращает правильное среднее значение для
      списка чисел.
     */
    @Test
    void testGetAverage() {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);
        double expectedAverage = 6;
        double result = getAvarage(numbers);
        assertEquals(expectedAverage, result, 0.01);
    }

    /*
        - метод getMax() возвращает правильное максимальное значение для
      списка чисел.
     */
    @Test
    void testGtMax() {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);
        int expected = 10;
        int result = getMax(numbers);
        assertEquals(expected, result);
    }
}