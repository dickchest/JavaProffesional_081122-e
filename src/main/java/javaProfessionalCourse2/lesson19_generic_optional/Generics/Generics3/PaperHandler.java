package javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics3;

import javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics2.Paper;

public class PaperHandler<T> implements GarbageHandler<Paper, T> {
    @Override
    public void handle(Paper what, T how) {
        // здесь что-то делается с бумагой способом T
    }

    @Override
    public <E> void transfer(E dangerousWaste) {

    }
}
