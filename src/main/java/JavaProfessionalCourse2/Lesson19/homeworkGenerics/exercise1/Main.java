package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise1;

public class Main {
    public static void main(String[] args) {
        Box <String> box = new Box<>();
        box.put("1");
        System.out.println(box.get());

        Box <Integer> box1 = new Box<>();
        box1.put(1);
        System.out.println(box1.get());

        Box box2 = new Box();
        box2.put("askldjf sldkfj aldskfj");
        System.out.println(box2.get());
    }
}
