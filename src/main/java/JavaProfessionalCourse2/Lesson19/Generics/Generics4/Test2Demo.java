package JavaProfessionalCourse2.Lesson19.Generics.Generics4;

public class Test2Demo {
    public static void main(String[] args) {
        Test2<Integer, String> test21 = new Test2<>(125, "Generic");
        test21.print();

        Test2<Double, Integer> test22 = new Test2<>(125.55, 10);
        test22.print();
    }
}
