package JavaProfessionalCourse2.Lesson19.Generics.Generics3;

public interface GarbageHandler<T, S> {
    void handle (T what, S how);

    <E> void transfer(E dangerousWaste);
}
