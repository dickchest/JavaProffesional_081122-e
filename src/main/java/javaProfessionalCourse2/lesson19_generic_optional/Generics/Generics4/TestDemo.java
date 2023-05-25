package javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics4;

public class TestDemo {
    public static void main(String[] args) {
        // instance of INTEGER type
        Test<Integer> test1 = new Test<>(15);
        System.out.println(test1.getObj());

        // instance of String type
        Test<String> test2 = new Test<>("java");
        System.out.println(test2.getObj());
    }
}
