package javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics5;

public class PairDemo {
    public static void main(String[] args) {
        PairInteger firstPair = new PairInteger(2,5);
        PairDouble secondPair = new PairDouble(20.5,5.5);

        PairUniversal<String, Integer> pairUniversal1 = new PairUniversal<>("Java", 19);
        PairUniversal<Integer, User> pairUniversal2 = new PairUniversal<>(1, new User("John", 20));




    }
}
