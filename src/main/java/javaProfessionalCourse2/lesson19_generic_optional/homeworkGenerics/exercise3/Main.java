package javaProfessionalCourse2.lesson19_generic_optional.homeworkGenerics.exercise3;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("one", 1);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
