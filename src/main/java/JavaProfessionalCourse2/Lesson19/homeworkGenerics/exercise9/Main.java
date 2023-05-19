package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise9;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new Map<>();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

        System.out.println(map.remove(1));
        System.out.println(map.toString());
        System.out.println(map.remove(4));

    }
}
