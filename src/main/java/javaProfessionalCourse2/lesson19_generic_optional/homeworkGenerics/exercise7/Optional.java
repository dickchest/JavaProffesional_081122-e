package javaProfessionalCourse2.lesson19_generic_optional.homeworkGenerics.exercise7;

import java.util.NoSuchElementException;

/*
7)  Создайте класс Optional для представления значения, которое может
    отсутствовать. Реализуйте методы isPresent(), get() и orElse().
    Используйте Generics для возможности хранения в Optional объектов
    разных типов.
 */
public class Optional <T>{
    private T object;

    public Optional() {
    }

    public Optional(T object) {
        this.object = object;
    }

    public T getObject() {
        if (object == null) {
            throw new NoSuchElementException("No value present");
        }
        return object;
    }

    public boolean isPresent() {
        return object != null;
    }

    public T orElse(T other) {
        return object != null ? object : other;
    }
}
