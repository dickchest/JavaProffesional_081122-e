package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise5;
/*
5)  Создайте класс Stack, реализующий стек на основе массива или списка.
    Используйте Generics для обеспечения типобезопасности и возможности
    передачи в стек объектов разных типов.

 */
import java.util.ArrayList;

public class Stack <T>{
    private ArrayList<T> stack;

    // конструктор
    public Stack() {
        stack = new ArrayList<>();
    }

    //    push(element): Добавляет элемент в верхушку стека.
    public void push(T element) {
        stack.add(element);
    }
//
//  pop(): Удаляет и возвращает элемент из верхуши стека. Если стек пуст, вызов pop() может привести к ошибке.
    public T pop() {
        return stack.remove(stack.size()-1);
    }
//
//  peek(): Возвращает элемент из верхуши стека без его удаления. Этот метод позволяет просмотреть элемент, находящийся на вершине стека,
//  без изменения самого стека. Если стек пуст, вызов peek() может вернуть нулевое значение или выбросить исключение.
    public T peek() {
        return stack.get(stack.size()-1);
    }
//
//  isEmpty(): Проверяет, является ли стек пустым. Возвращает true, если стек не содержит элементов, и false в противном случае.
    public boolean isEmpty() {
        return stack.isEmpty();
    }
//


}
