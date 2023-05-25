package javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics3;

public interface GarbageHandler<T, S> {
    void handle (T what, S how);

    <E> void transfer(E dangerousWaste);
}
