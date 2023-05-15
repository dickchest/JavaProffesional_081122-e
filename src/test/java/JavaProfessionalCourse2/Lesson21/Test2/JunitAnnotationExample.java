package JavaProfessionalCourse2.Lesson21.Test2;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JunitAnnotationExample {
    private ArrayList<String> list = new ArrayList<>();

    @BeforeClass
    public static void method1() {
        System.out.println("Using @BeforeClass, execute before all test cases");
    }

    @Before
    public void method2() {
        System.out.println("Using @Before, execute before each test cases");
    }

    @Test
    public void method3() {
        list.add("test");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void method33() {
        list.add("test2");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }
    @After
    public void method4() {
        System.out.println("Using @After, execute after each test cases");
    }

    @AfterClass
    public static void method5() {
        System.out.println("Using @AfterClass, execute after all test cases");
    }
}
