package JavaProfessionalCourse2.Lesson19.Generics.Generics3;

public class GarbageHandlerImplemitation <T,S> implements GarbageHandler<T,S> {
    @Override
    public void handle(T what, S how) {
        // здесь что-то делается с мусором типа Т способом S
    }

    @Override
    public <E> void transfer(E dangerousWaste) {

    }
}
