package JavaProfessionalCourse2.Lesson19.Generics.Generics4;

public class Test<T> {
    T obj;

    public Test(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
