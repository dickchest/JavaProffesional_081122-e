package javaProfessionalCourse2.lesson30.annotation.mainAnnotations;

import java.util.HashMap;
import java.util.Map;

//rawtypes, unchecked/
public class SuppressWarningsDemo {

    public static void main(String[] args) {
        SuppressWarningsDemo swDemo = new SuppressWarningsDemo();
        swDemo.testSuppresWarning();
    }

    private void testSuppresWarning() {
        Map testMap = new HashMap();
        testMap.put(1,"Item_1");
        testMap.put(2,"Item_2");
        testMap.put(3,"Item_3");
    }
}
