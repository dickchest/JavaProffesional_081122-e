package JavaProfessionalCourse2.Lesson19.Generics.Generics2;

public class BoxUniversal<T> {
    private T item;

    public BoxUniversal(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
