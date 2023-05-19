package JavaProfessionalCourse2.Lesson20;

import java.util.Stack;

public class temp {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("1");
        stack.push("2");
        stack.push("3");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());

    }
}
