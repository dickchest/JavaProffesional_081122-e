package javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics4;

public class Test<T> {
    T obj;

    public Test(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
