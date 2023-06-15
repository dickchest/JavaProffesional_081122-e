package javaProfessionalCourse2.lesson30.annotation.mainAnnotations;

public class DeprecatedDemo {
    @Deprecated(since = "4.5", forRemoval = true)
    public void testLegasyFunction() {
        System.out.println("This is a legacy function");
    }
}
