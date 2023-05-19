package Algorithms.lesson1.homework1;

import org.junit.jupiter.api.Test;

import static Algorithms.lesson1.homework1.Exercise2.sumSqrt;
import static org.junit.jupiter.api.Assertions.*;

class Exercise2Test {

    @Test
    void main1() {
        int[] array = {3, 6, 4, 7, 2, 1, 9};
        assertEquals(196, sumSqrt(array));
    }

    @Test
    void main2() {
        int[] array = {0,0,0};
        assertEquals(0, sumSqrt(array));
    }

    @Test
    void main3() {
        int[] array = {};
        assertEquals(0, sumSqrt(array));
    }
}