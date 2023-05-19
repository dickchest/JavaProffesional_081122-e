package JavaProfessionalCourse2.Lesson19.Generics.Generics7;

import java.util.List;

public class PecsExample {
    // PECS - Producer Extends Consumer Super

    public void printList(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    public void addNumber(List<? super Integer> list) {
        list.add(new Integer(1));
        list.add(new Integer(10));
    }
}
