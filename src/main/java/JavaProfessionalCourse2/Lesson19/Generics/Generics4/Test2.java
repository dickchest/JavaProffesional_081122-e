package JavaProfessionalCourse2.Lesson19.Generics.Generics4;

public class Test2<T,U> {
    T obj;
    U type2;

    public T getObj() {
        return obj;
    }

    public U getType2() {
        return type2;
    }

    public Test2(T obj, U type2) {
        this.obj = obj;
        this.type2 = type2;
    }

    public void print() {
        System.out.println(obj);
        System.out.println(type2);
    }
}
