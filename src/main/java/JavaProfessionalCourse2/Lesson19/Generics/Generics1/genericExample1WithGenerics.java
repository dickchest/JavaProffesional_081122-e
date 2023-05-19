package JavaProfessionalCourse2.Lesson19.Generics.Generics1;

import java.util.ArrayList;
import java.util.List;

public class genericExample1WithGenerics {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        list1.add("Hello!");
        list1.add("Peter");

        list2.add("Hello");
//        list2.add(123);
        
        printCollection(list1);
        printCollection(list2);
    }
    
    public static void printCollection(List<String> list) {
        for (int i = 0; i <list.size() ; i++) {
            String item = (String) list.get(i);
            System.out.println(item);
        }
    }
}
