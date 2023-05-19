package JavaProfessionalCourse2.Lesson19.Generics.Generics3;

import JavaProfessionalCourse2.Lesson19.Generics.Generics2.Paper;

public class PaperHandler<T> implements GarbageHandler<Paper, T> {
    @Override
    public void handle(Paper what, T how) {
        // здесь что-то делается с бумагой способом T
    }

    @Override
    public <E> void transfer(E dangerousWaste) {

    }
}
