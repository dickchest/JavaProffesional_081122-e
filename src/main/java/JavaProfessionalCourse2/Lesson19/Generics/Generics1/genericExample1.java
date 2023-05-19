package JavaProfessionalCourse2.Lesson19.Generics.Generics1;

import java.util.ArrayList;
import java.util.List;

public class genericExample1 {
    public static void main(String[] args) {
        List list1 = new ArrayList<>();
        List list2 = new ArrayList<>();
        
        list1.add("Hello!");
        list1.add("Peter");

        list2.add("Hello");
        list2.add(123);
        
        printCollection(list1);
        printCollection(list2);
    }
    
    public static void printCollection(List list) {
        for (int i = 0; i <list.size() ; i++) {
            String item = (String) list.get(i);
            System.out.println(item);
        }
    }
}
