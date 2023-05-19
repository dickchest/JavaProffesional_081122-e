package JavaProfessionalCourse2.Lesson21.lessoncode;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculationUtilsTest {
    int x;
    int y;

    @BeforeEach
    void setUp() {
        x = 5;
        y = 7;
    }

    @Test
    void testAdd() {
        int expectedResult = 12;
        Assert.assertEquals("5 + 7 must be equal 12", expectedResult, CalculationUtils.add(x, y) );
    }

    @Test
    void testSub() {
        int expectedResult = -2;
        Assert.assertEquals("5 - 7 must be equal 12", expectedResult, CalculationUtils.sub(x, y) );
    }
}